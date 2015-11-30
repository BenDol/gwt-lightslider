# gwt-lightslider [![Build Status](https://travis-ci.org/BenDol/gwt-lightslider.svg?branch=master)](https://travis-ci.org/BenDol/gwt-lightslider)

GwtLightSlider is a [LightSlider](http://sachinchoolur.github.io/lightslider) Wrapper for Google Web Toolkit. The objective of this library is to provide easy access to the already existing LightSlider Javascript library.

## Getting Started
First you will need to import the dependency:
```xml
<dependency>
    <groupId>nz.co.doltech</groupId>
    <artifactId>gwt-lightslider</artifactId>
    <version>1.0-SNAPSHOT</version>
</dependency>
```

Now that you have the dependency in your project you can add them to your GWT module.
```xml
<inherits name="nz.co.doltech.gwtls.LightSlider" />
```
or you can import the module with more extensive information for debugging.
```xml
<!-- Debugging of Interactions, providing non-minified js/css -->
<inherits name="nz.co.doltech.gwtls.LightSliderDebug" />
```
Note that the default `LightSlider` modules assume you have JQuery library already loaded, to make LightSlider load JQuery you can add the following module:
```xml
<!-- Loads JQuery for you -->
<inherits name="nz.co.doltech.gwtls.LightSliderWithJQuery" />

<!-- Or, same thing for Debugging -->
<inherits name="nz.co.doltech.gwtls.LightSliderDebugWithJQuery" />
```

## Usage Guide
The use is simple and can be done using standard Java or can make use of the UiBinder.

Import the xmlns for uibinder 
```xml
xmlns:ls="urn:import:nz.co.doltech.gwtls.client.ui"
```

Then make use of the Widget, like so:
```xml
<ls:LightSlider ui:field="slider" gallery="true" adaptiveHeight="true">
    <ls:Slide imageUrl="images/1.png" thumbUrl="thumbs/1.png" />
    <ls:Slide imageUrl="images/2.png" thumbUrl="thumbs/2.png" />
</ls:LightSlider>
```

Slides can also be added dynamically:
```java
@UiField LightSlider slider;

public void addNewSlide() {
   slider.add(new Slider("images/2.png", "thumbs/2.png"));
}
```

## API Documentation
You can find the libraries API documentation [here](https://github.com/BenDol/gwt-lightslider/wiki/API-Documentation)

## Issues
If you find any issues please list them in the [issue tracker](https://github.com/BenDol/gwt-lightslider/issues) and it will be looked into as soon as possible.

## Contributing
TODO
