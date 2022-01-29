<h1 align="center">
Compose-Curved-Scroll-library
</h1>

[![](https://jitpack.io/v/mohamedtamer0/Compose-Curved-Scroll-library.svg)](https://jitpack.io/#mohamedtamer0/Compose-Curved-Scroll-library)


Compose Curved-Scroll is an Android Jetpack Compose library made with ❤️, it's a simple yet customizable implementation for a Curved-Scroll in Jetpack Compose.


---
## Preview
<div align="center">
<br/>

Dark theme            |  Light theme
:-------------------------:|:-------------------------:
<img src="https://user-images.githubusercontent.com/51374446/151675416-da75b202-63e4-43d1-9e90-8ad9674f7bf6.jpg" width="200" height="400" />  | <img src="https://user-images.githubusercontent.com/51374446/151675464-228e20bf-1449-48cd-a49d-09d0532fed9a.jpg" width="200" height="400" />

Dark theme            |  Light theme
:-------------------------:|:-------------------------:
<img src="https://user-images.githubusercontent.com/51374446/151675643-5f9c33a3-a755-4a34-a3ed-594d0ca73280.jpg" width="600" height="200" />  | <img src="https://user-images.githubusercontent.com/51374446/151675659-321fe50f-5a1d-40ba-b2a1-1c636749544a.jpg" width="600" height="200" />

</div>

<br/>

---
## Installation

### - Step 1- Add jitpack in your project build.gradle
```groovy
allprojects {
    repositories {
        ...
        maven { url "https://jitpack.io" }
    }
}
```

### - Step 2- Add the dependency in your app build.gradle

```groovy
dependencies {
    ...
    implementation 'com.github.mohamedtamer0:Compose-Curved-Scroll-library:1.0'
}
```

### - Step 3- Optional

#### in some **Gradle** :stuck_out_tongue_closed_eyes: versions in Android studio you might need to add to your settings.gradle
```groovy
repositories {
    ...
    maven { url 'https://jitpack.io' }
}
```


<br/>

---
# Use
## You can Add Infinite number of items 

```Kotlin
//List of item add
val items = listOf(
    "Name1",
    "Name2",
    "Name3",
    "Name4",
    "Name5",
    "Name6",
    "Name7",
    "Name8",
    "Name9"
)
```

```Kotlin
  CurvedScrollView(items.size) { index ->
      Column(
          modifier = Modifier.wrapContentSize()
      ) {
          Image(
              painter = painterResource(
                  id =
                  when (index) {
                      0 -> R.drawable.a
                      1 -> R.drawable.b
                      2 -> R.drawable.c
                      3 -> R.drawable.d
                      4 -> R.drawable.e
                      5 -> R.drawable.f
                      6 -> R.drawable.g
                      7 -> R.drawable.h
                      8 -> R.drawable.i
                      else -> R.drawable.j
                  }
              ),
              contentDescription = "Curved Image",
              contentScale = ContentScale.Crop,
              modifier = Modifier
                  .size(70.dp)
                  .clip(CircleShape)
          )

          Spacer(modifier = Modifier.padding(5.dp))

          Text(
              text = items[index],
              style = MaterialTheme.typography.h6
          )
      }
  }
```

```Kotlin
Image(
    painter = painterResource(id = R.drawable.a),
    contentDescription = "Curved Logo Image",
    contentScale = ContentScale.Crop,
    modifier = Modifier
        .width(120.dp)
        .height(150.dp)
        .clip(RoundedCornerShape(20.dp))
)
```

