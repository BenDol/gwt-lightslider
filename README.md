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

## Issues
If you find any issues please list them in the [issue tracker](https://github.com/BenDol/gwt-lightslider/issues) and it will be looked into as soon as possible.

## Contributing
TODO
