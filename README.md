# SlideView

A simple slide library for Android.

[![License](https://img.shields.io/badge/License-MIT-blue.svg)](http://www.apache.org/licenses/LICENSE-2.0)

## Preview

<img src="https://image.ibb.co/jNqQfa/slideview1.png" alt="SlideView" width="240"> <img src="https://image.ibb.co/m1Od0a/slideview2.png" alt="SlideView2" width="240">

Get the sample apk [here](https://github.com/)


## Setup

### Gradle

Add this to your project level `build.gradle`:

```groovy
allprojects {
 repositories {
    jcenter()
    maven { url "https://jitpack.io" }
 }
}
```

Add this to your app `build.gradle`:

```groovy
dependencies {
	compile 'com.github.MAXDeliveryNG.slideview:1.0.0'
}
```

## Usage


The SlideView is very easy to use. Just add it to your layout like any other view. 

##### Via XML
Here's a basic implementation.
```xml
 <ng.max.slideview.SlideView
        android:id="@+id/slideView"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        app:buttonBackgroundColor="@color/button_bg_color"
        app:buttonImage="@drawable/button_img"
        app:slideBackgroundColor="@color/slide_bg_color"
        app:slideText="@string/slide_text"
        app:slideTextColor="@color/slide_text_color"
        />
```


Here's an example with all the view attributes.

```xml
<ng.max.slideview.SlideView
        android:id="@+id/slideView"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        app:buttonBackgroundColor="@color/button_bg_color"
        app:buttonImage="@drawable/button_img"
        app:slideBackgroundColor="@color/slide_bg_color"
        app:slideText="@string/slide_text"
        app:slideTextColor="@color/slide_text_color"
        app:animateSlideText="true"
        app:reverseSlide="false"
        app:strokeColor="@color/slide_stroke_color"
        app:buttonImageDisabled="@drawable/button_img_disabled"
        />

```

### Attributes information

|Attribute name|Description|Default value|
|:-:|:-:|:-:|
|slideBackgroundColor|The slide background color| `#3F51B5` |
|buttonBackgroundColor|The slide button background color| `#FFFFFF`|
|slideTextColor|The color of the slide label |`#FFFFFF`|
|buttonImage|The drawable on the button | double chevron icon |
|slideText|The slide label| `none` |
|animateSlideText|If `true`, the label fades out, while the slide is in progress| `true` |
|strokeColor|If set, a stroke is drawn around the slide background | `none` |
|reverseSlide|If `true`, the SlideView is reversed. | `false` |
|buttonImageDisabled| The drawable to be used as the button image when the SlideView is disabled| the default drawable|

