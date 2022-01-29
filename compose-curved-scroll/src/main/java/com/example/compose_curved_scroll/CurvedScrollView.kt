package com.example.compose_curved_scroll

import androidx.compose.foundation.gestures.FlingBehavior
import androidx.compose.foundation.gestures.ScrollScope
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import kotlin.math.PI
import kotlin.math.abs
import kotlin.math.cos

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun CurvedScrollView(
    itemCount: Int,
    item: @Composable (Int) -> Unit
) {
    val scrollState = rememberScrollState()
    var size = remember { mutableStateOf(IntSize.Zero) }
    val scope = rememberCoroutineScope()
    val indices = remember { IntArray(itemCount) { 0 } }

    val flingBehaviour = object : FlingBehavior {
        override suspend fun ScrollScope.performFling(initialVelocity: Float): Float {
            val value = scrollState.value
            indices.minByOrNull { abs(it - value) }?.let {
                scope.launch {
                    scrollState.animateScrollTo(it)
                }
            }
            return initialVelocity
        }
    }

    Box(
        modifier = Modifier
            .onSizeChanged {
                size.value = it
            }
    ) {
        Layout(
            content = {
                repeat(itemCount) {
                    item(it)
                }
            },
            modifier = Modifier.verticalScroll(
                scrollState, flingBehavior = flingBehaviour
            )
        ) { measurables, constraints ->
            val itemSpacing = 16.dp.roundToPx()
            var contentHeight = (itemCount - 1) * itemSpacing

            val placeables = measurables.mapIndexed { index, measurable ->
                val placeable = measurable.measure(constraints = constraints)
                contentHeight += if (index == 0 || index == measurables.lastIndex) {
                    placeable.height / 2
                } else {
                    placeable.height
                }
                placeable
            }

            layout(constraints.maxWidth, size.value.height + contentHeight) {
                val startOffset = size.value.height / 2 - placeables[0].height / 2
                var yPosition = startOffset

                val scrollPercent = scrollState.value.toFloat() / scrollState.maxValue

                placeables.forEachIndexed { index, placeable ->
                    val elementRatio = index.toFloat() / placeables.lastIndex
                    val interpolatedValue = cos((scrollPercent - elementRatio) * PI)
                    val indent = interpolatedValue * size.value.width / 2

                    placeable.placeRelativeWithLayer(x = indent.toInt(), y = yPosition) {
                        alpha = interpolatedValue.toFloat()
                    }
                    indices[index] = yPosition - startOffset
                    yPosition += placeable.height + itemSpacing
                }
            }
        }
    }
}
