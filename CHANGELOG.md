Change Log
==========

Version 1.0.0 *(2017-02-16)*
----------------------------

- Initial release.


Version 1.0.1 *(2017-07-02)*
----------------------------

- Add "slideTextSize" attribute for setting SlideView's text size.
- Add a getter for the TextView. This is useful if you want to further customize the text. 


Version 1.0.2 *(2017-09-19)*
----------------------------

- Fix issue where SlideView's parent view intercepts touch events.


Version 1.1.0 *(2017-11-24)*
----------------------------

- Add "sv_" prefix to all library attributes to avoid conflicting with attributes in other libraries or attributes defined by users.
- The internal Slider now extends "AppCompatSeekBar" instead of "SeekBar"
- Update internal dependencies.


Version 1.1.1 *(2018-07-01)*
----------------------------

- Add `setStokeColor` method for runtime configuration of the view's stroke color.
- Add `setReversed` method for runtime configuration of the view's `reversed` property.
- Add `isReversed` getter method for the view's `reversed` property.
- Add `setButtonBackgroundColor` method for runtime configuration of the view's background color using a color int value.
- Update internal dependencies.
