# SlideView

A simple, yet awesome sliding button for Android.

[![CircleCI](https://circleci.com/gh/MAXDeliveryNG/slideview/tree/master.svg?style=svg)](https://circleci.com/gh/MAXDeliveryNG/slideview/tree/master)
[![JitPack](https://jitpack.io/v/MAXDeliveryNG/slideview.svg)](https://jitpack.io/#MAXDeliveryNG/slideview)
[![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-SlideView-9C27B0.svg)](https://android-arsenal.com/details/1/5304)
[![License](https://img.shields.io/badge/License-MIT-blue.svg)](https://github.com/MAXDeliveryNG/slideview/blob/master/LICENSE.txt)
[![Min SDK](https://img.shields.io/badge/Min%20SDK-14-e91e63.svg)](https://developer.android.com/about/versions/android-4.0.html)

## Preview

<img src="/art/screenshot_1.png" alt="SlideView" width="240"> <img src="/art/screenshot_2.png" alt="SlideView2" width="240">

Get the sample apk [here](https://github.com/MAXDeliveryNG/slideview/releases/download/1.0.0/sample.apk/)


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
	implementation 'com.github.MAXDeliveryNG:slideview:1.1.0'
}
```

## Usage

The SlideView is very easy to use. Just add it to your layout like any other view. 

> From version 1.1.0, all SlideView's attributes are prefixed "sv_", this 
is to avoid conflicting with attributes in other libraries or attributes defined by users.

##### Via XML

Here's a basic implementation.

```xml
 <ng.max.slideview.SlideView
        android:id="@+id/slideView"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        app:sv_buttonBackgroundColor="@color/button_bg_color"
        app:sv_buttonImage="@drawable/button_img"
        app:sv_slideBackgroundColor="@color/slide_bg_color"
        app:sv_slideText="@string/slide_text"
        app:sv_slideTextColor="@color/slide_text_color" />
```

Here's an example with all the view attributes.

```xml
<ng.max.slideview.SlideView
        android:id="@+id/slideView"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        app:sv_buttonBackgroundColor="@color/button_bg_color"
        app:sv_buttonImage="@drawable/button_img"
        app:sv_slideBackgroundColor="@color/slide_bg_color"
        app:sv_slideText="@string/slide_text"
        app:sv_slideTextColor="@color/slide_text_color"
        app:sv_slideTextSize="16sp"
        app:sv_animateSlideText="true"
        app:sv_reverseSlide="false"
        app:sv_strokeColor="@color/slide_stroke_color"
        app:sv_buttonImageDisabled="@drawable/button_img_disabled" />

```

### Attributes information

|Attribute name|Description|Default value|
|:-:|:-:|:-:|
|slideBackgroundColor|The slide background color| `#3F51B5` |
|buttonBackgroundColor|The slide button background color| `#FFFFFF`|
|slideTextColor|The color of the slide label |`#FFFFFF`|
|buttonImage|The drawable on the button | double chevron icon |
|slideText|The slide label| `none` |
|slideTextSize|The label's size| 16sp |
|animateSlideText|If `true`, the label fades out while the slide is in progress| `true` |
|strokeColor|If set, a stroke is drawn around the slide background | `none` |
|reverseSlide|If `true`, the SlideView is reversed | `false` |
|buttonImageDisabled| The drawable to be used as the button image when the SlideView is disabled| the default drawable|

Note: All color attributes can be replaced with a `ColorStateList` so the SlideView can use the appropriate colors for the enabled and disabled states. See the sample module for examples. 

### Listening for slide actions on the SlideView

You can set a listener to be notified when the user slides across the SlideView. An example is shown below.

```java
SlideView slideView = (SlideView) findViewById(R.id.slideView);
slideView.setOnSlideCompleteListener(new SlideView.OnSlideCompleteListener() {
            @Override
            public void onSlideComplete(SlideView slideView) {
                // vibrate the device
                Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                vibrator.vibrate(100);

                // go to a new activity
                startActivity(new Intent(MainActivity.this, NewActivity.class));
            }
        });

```


### Setting the view attributes via code

For convenience, many of the SlideView attributes can be set via code.

```java 
 // set the label
 setText(CharSequence text); 
 
 // set the text size
 setTextSize(int size);
 
 // set the drawable for the button
 setButtonImage(Drawable image);
 
 // set the label color
 setTextColor(@ColorInt int color) ;
 
 // set the label color with a ColorStateList
 setTextColor(ColorStateList colors);
 
 // set the button drawable for disabled state
 setButtonImageDisabled(Drawable image);
 
 // set the button background color
 setButtonBackgroundColor(ColorStateList color);
 
 // set the slide background color
 setSlideBackgroundColor(ColorStateList color);
 
```

Note: for the methods that take a `ColorStateList`, you can easily use a single color by converting it to a `ColorStateList` with the method `ColorStateList.valueOf(int color);`

## Caveat 
The view height is currently fixed so you should use `wrap_content` when defining the view height in your layout. 

## Author
[Kizito Nwose](https://github.com/kizitonwose)


## Contributing
If you find any bugs, please feel free to fix it and send a pull request or [open an issue.](https://github.com/MAXDeliveryNG/slideview/issues) 

## License
```
Copyright (c) 2017 MAXDeliveryNG

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```
