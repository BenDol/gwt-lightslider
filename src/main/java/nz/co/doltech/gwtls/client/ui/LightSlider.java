/*
 * Copyright 2015 Doltech Systems Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package nz.co.doltech.gwtls.client.ui;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.event.shared.HandlerRegistration;
import nz.co.doltech.gwtls.client.base.ComplexWidget;
import nz.co.doltech.gwtls.client.events.AfterSlideEvent;
import nz.co.doltech.gwtls.client.events.AfterSlideHandler;
import nz.co.doltech.gwtls.client.events.BeforeNextSlideEvent;
import nz.co.doltech.gwtls.client.events.BeforeNextSlideHandler;
import nz.co.doltech.gwtls.client.events.BeforePrevSlideEvent;
import nz.co.doltech.gwtls.client.events.BeforePrevSlideHandler;
import nz.co.doltech.gwtls.client.events.BeforeSlideEvent;
import nz.co.doltech.gwtls.client.events.BeforeSlideHandler;
import nz.co.doltech.gwtls.client.events.BeforeStartEvent;
import nz.co.doltech.gwtls.client.events.BeforeStartHandler;
import nz.co.doltech.gwtls.client.events.SliderLoadEvent;
import nz.co.doltech.gwtls.client.events.SliderLoadHandler;
import nz.co.doltech.gwtls.client.options.Responsive;

public class LightSlider extends ComplexWidget {

    private JsLightSlider impl;

    // Options

    private int item = 1;
    private boolean autoWidth;
    private int slideMove = 1;
    private int slideMargin = 10;
    private String addClass = "";
    private String mode = "slide";
    private boolean useCss = true;
    private String cssEasing = "ease";
    private String easing = "linear";
    private int speed = 400;
    private boolean auto;
    private boolean pauseOnHover;
    private boolean loop;
    private boolean slideEndAnimation = true;
    private int pause = 2000;
    private boolean keyPress;
    private boolean controls = true;
    private String prevHtml = "";
    private String nextHtml = "";
    private boolean rtl;
    private boolean adaptiveHeight;
    private boolean vertical;
    private int verticalHeight = 500;
    private int vThumbWidth = 100;
    private int thumbItem = 10;
    private boolean pager = true;
    private boolean gallery = false;
    private int galleryMargin = 5;
    private int thumbMargin = 5;
    private String currentPagerPosition = "middle";
    private boolean enableTouch = true;
    private boolean enableDrag = true;
    private boolean freeMove = true;
    private int swipeThreshold = 40;
    private Responsive responsive = Responsive.create();

    public LightSlider() {
        setElement(Document.get().createULElement());
        getElement().setId("lightSlider");
    }

    @Override
    protected void onLoad() {
        if(impl == null) {
            initialize();
        }
    }

    // Setters/Getters

    public int getItem() {
        return item;
    }

    /**
     * number of slides to show at a time.
     */
    public void setItem(int item) {
        this.item = item;
    }

    public boolean isAutoWidth() {
        return autoWidth;
    }

    /**
     * Custom width for each slide.
     */
    public void setAutoWidth(boolean autoWidth) {
        this.autoWidth = autoWidth;
    }

    public int getSlideMove() {
        return slideMove;
    }

    /**
     * Number of slides to be moved at a time.
     */
    public void setSlideMove(int slideMove) {
        this.slideMove = slideMove;
    }

    public int getSlideMargin() {
        return slideMargin;
    }

    /**
     * Spacing between each slide.
     */
    public void setSlideMargin(int slideMargin) {
        this.slideMargin = slideMargin;
    }

    public String getAddClass() {
        return addClass;
    }

    /**
     * Add custom class for slider, can be used to set different
     * style for different sliders.
     */
    public void setAddClass(String addClass) {
        this.addClass = addClass;
    }

    public String getMode() {
        return mode;
    }

    /**
     * Type of transition 'slide' and 'fade'.
     */
    public void setMode(String mode) {
        this.mode = mode;
    }

    public boolean isUseCss() {
        return useCss;
    }

    /**
     * If true LightSlider will use CSS transitions. if falls jquery
     * animation will be used.
     */
    public void setUseCss(boolean useCss) {
        this.useCss = useCss;
    }

    public String getCssEasing() {
        return cssEasing;
    }

    /**
     * Type of easing to be used for css animations.
     */
    public void setCssEasing(String cssEasing) {
        this.cssEasing = cssEasing;
    }

    public String getEasing() {
        return easing;
    }

    /**
     * Type of easing to be used for jquery animations.
     */
    public void setEasing(String easing) {
        this.easing = easing;
    }

    public int getSpeed() {
        return speed;
    }

    /**
     * Transition duration (in ms), e.g. speed:400.
     */
    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public boolean isAuto() {
        return auto;
    }

    /**
     * If true, the Slider will automatically start to play.
     */
    public void setAuto(boolean auto) {
        this.auto = auto;
    }

    public boolean isPauseOnHover() {
        return pauseOnHover;
    }

    /**
     * Pause autoplay on hover.
     */
    public void setPauseOnHover(boolean pauseOnHover) {
        this.pauseOnHover = pauseOnHover;
    }

    public boolean isLoop() {
        return loop;
    }

    /**
     * If false, will disable the ability to loop back to the
     * beginning of the slide when on the last element.
     */
    public void setLoop(boolean loop) {
        this.loop = loop;
    }

    public boolean isSlideEndAnimation() {
        return slideEndAnimation;
    }

    /**
     * Enable slideEnd animation.
     */
    public void setSlideEndAnimation(boolean slideEndAnimation) {
        this.slideEndAnimation = slideEndAnimation;
    }

    public int getPause() {
        return pause;
    }

    /**
     * The time (in ms) between each auto transition.
     */
    public void setPause(int pause) {
        this.pause = pause;
    }

    public boolean isKeyPress() {
        return keyPress;
    }

    /**
     * Enable keyboard navigation.
     */
    public void setKeyPress(boolean keyPress) {
        this.keyPress = keyPress;
    }

    public boolean isControls() {
        return controls;
    }

    /**
     * If false, prev/next buttons will not be displayed.
     */
    public void setControls(boolean controls) {
        this.controls = controls;
    }

    public String getPrevHtml() {
        return prevHtml;
    }

    /**
     * Custom html for prev control.
     */
    public void setPrevHtml(String prevHtml) {
        this.prevHtml = prevHtml;
    }

    public String getNextHtml() {
        return nextHtml;
    }

    /**
     * Custom html for next control.
     */
    public void setNextHtml(String nextHtml) {
        this.nextHtml = nextHtml;
    }

    public boolean isRtl() {
        return rtl;
    }

    /**
     * Change direction to right-to-left.
     */
    public void setRtl(boolean rtl) {
        this.rtl = rtl;
    }

    public boolean isAdaptiveHeight() {
        return adaptiveHeight;
    }

    /**
     * Dynamically adjust slider height based on each slide's height.
     */
    public void setAdaptiveHeight(boolean adaptiveHeight) {
        this.adaptiveHeight = adaptiveHeight;
    }

    public boolean isVertical() {
        return vertical;
    }

    /**
     * change slide's direction from horizontal to Vertical.
     */
    public void setVertical(boolean vertical) {
        this.vertical = vertical;
    }

    public int getVerticalHeight() {
        return verticalHeight;
    }

    /**
     * Set height of slider if vertical mode is active and item more than 1.
     */
    public void setVerticalHeight(int verticalHeight) {
        this.verticalHeight = verticalHeight;
    }

    public int getVThumbWidth() {
        return vThumbWidth;
    }

    /**
     * Width of gallery thumbnail while vertical mode active
     */
    public void setVThumbWidth(int vThumbWidth) {
        this.vThumbWidth = vThumbWidth;
    }

    public int getThumbItem() {
        return thumbItem;
    }

    /**
     * Number of gallery thumbnail to show at a time.
     */
    public void setThumbItem(int thumbItem) {
        this.thumbItem = thumbItem;
    }

    public boolean isPager() {
        return pager;
    }

    /**
     * Enable pager option.
     */
    public void setPager(boolean pager) {
        this.pager = pager;
    }

    public boolean isGallery() {
        return gallery;
    }

    /**
     * Enable thumbnails gallery.
     */
    public void setGallery(boolean gallery) {
        this.gallery = gallery;
    }

    public int getGalleryMargin() {
        return galleryMargin;
    }

    /**
     * Spacing between gallery and slide.
     */
    public void setGalleryMargin(int galleryMargin) {
        this.galleryMargin = galleryMargin;
    }

    public int getThumbMargin() {
        return thumbMargin;
    }

    /**
     * Spacing between each thumbnails.
     */
    public void setThumbMargin(int thumbMargin) {
        this.thumbMargin = thumbMargin;
    }

    public String getCurrentPagerPosition() {
        return currentPagerPosition;
    }

    /**
     * Position of thumbnails . 'left', 'middle', 'right'.
     */
    public void setCurrentPagerPosition(String currentPagerPosition) {
        this.currentPagerPosition = currentPagerPosition;
    }

    public boolean isEnableTouch() {
        return enableTouch;
    }

    /**
     * Enables touch support.
     */
    public void setEnableTouch(boolean enableTouch) {
        this.enableTouch = enableTouch;
    }

    public boolean isEnableDrag() {
        return enableDrag;
    }

    /**
     * Enables desktop mouse drag support.
     */
    public void setEnableDrag(boolean enableDrag) {
        this.enableDrag = enableDrag;
    }

    public boolean isFreeMove() {
        return freeMove;
    }

    /**
     * Enable free move(no limit) while swipe or drag.
     */
    public void setFreeMove(boolean freeMove) {
        this.freeMove = freeMove;
    }

    public int getSwipeThreshold() {
        return swipeThreshold;
    }

    /**
     * Threshold for swipe actions to move left or right.
     */
    public void setSwipeThreshold(int swipeThreshold) {
        this.swipeThreshold = swipeThreshold;
    }

    public Responsive getResponsive() {
        return responsive;
    }

    /**
     * Separate settings per breakpoint.
     */
    public void setResponsive(Responsive responsive) {
        this.responsive = responsive;
    }

    // Methods

    public final void goToSlide(int slide) {
        impl.goToSlide(slide);
    }

    public final void goToPrevSlide() {
        impl.goToPrevSlide();
    }

    public final void goToNextSlide() {
        impl.goToNextSlide();
    }

    public final void getCurrentSlideCount() {
        impl.getCurrentSlideCount();
    }

    public final void refresh() {
        impl.refresh();
    }

    public final void play() {
        impl.play();
    }

    public final void pause() {
        impl.pause();
    }

    public final void destroy() {
        impl.destroy();
    }

    protected final JsLightSlider getImpl() {
        return impl;
    }

    // Events

    /**
     * Executes before slider start loading.
     */
    public HandlerRegistration addBeforeStartHandler(BeforeStartHandler handler) {
        return addHandler(handler, BeforeStartEvent.getType());
    }

    private void onBeforeStart(JsLightSlider impl) {
        BeforeStartEvent.fire(this, impl);
    }

    /**
     * Executes immediately after the slider is fully loaded.
     */
    public HandlerRegistration addSliderLoadHandler(SliderLoadHandler handler) {
        return addHandler(handler, SliderLoadEvent.getType());
    }

    private void onSliderLoad(JsLightSlider impl) {
        SliderLoadEvent.fire(this, impl);
    }

    /**
     * Executes immediately before each slide transition.
     */
    public HandlerRegistration addBeforeSlideHandler(BeforeSlideHandler handler) {
        return addHandler(handler, BeforeSlideEvent.getType());
    }

    private void onBeforeSlide(JsLightSlider impl) {
        BeforeSlideEvent.fire(this, impl);
    }

    /**
     * Executes immediately after each slide transition.
     */
    public HandlerRegistration addAfterSlideHandler(AfterSlideHandler handler) {
        return addHandler(handler, AfterSlideEvent.getType());
    }

    private void onAfterSlide(JsLightSlider impl) {
        AfterSlideEvent.fire(this, impl);
    }

    /**
     * Executes immediately before each "Next" slide transition.
     */
    public HandlerRegistration addBeforeNextSlideHandler(BeforeNextSlideHandler handler) {
        return addHandler(handler, BeforeNextSlideEvent.getType());
    }

    private void onBeforeNextSlide(JsLightSlider impl) {
        BeforeNextSlideEvent.fire(this, impl);
    }

    /**
     * Executes immediately before each "Prev" slide transition.
     */
    public HandlerRegistration addBeforePrevSlideHandler(BeforePrevSlideHandler handler) {
        return addHandler(handler, BeforePrevSlideEvent.getType());
    }

    private void onBeforePrevSlide(JsLightSlider impl) {
        BeforePrevSlideEvent.fire(this, impl);
    }

    /**
     * Initialize the Light Slider widget.
     */
    public void initialize() {
        initialize(getElement());
    }

    private native void initialize(Element e) /*-{
        var that = this;
        this.@nz.co.doltech.gwtls.client.ui.LightSlider::impl = $wnd.jQuery(e).lightSlider({
            // Options
            item: this.@nz.co.doltech.gwtls.client.ui.LightSlider::item,
            autoWidth: this.@nz.co.doltech.gwtls.client.ui.LightSlider::autoWidth,
            slideMove: this.@nz.co.doltech.gwtls.client.ui.LightSlider::slideMove,
            slideMargin: this.@nz.co.doltech.gwtls.client.ui.LightSlider::slideMargin,
            addClass: this.@nz.co.doltech.gwtls.client.ui.LightSlider::addClass,
            mode: this.@nz.co.doltech.gwtls.client.ui.LightSlider::mode,
            useCSS: this.@nz.co.doltech.gwtls.client.ui.LightSlider::useCss,
            cssEasing: this.@nz.co.doltech.gwtls.client.ui.LightSlider::cssEasing,
            easing: this.@nz.co.doltech.gwtls.client.ui.LightSlider::easing,
            speed: this.@nz.co.doltech.gwtls.client.ui.LightSlider::speed,
            auto: this.@nz.co.doltech.gwtls.client.ui.LightSlider::auto,
            pauseOnHover: this.@nz.co.doltech.gwtls.client.ui.LightSlider::pauseOnHover,
            loop: this.@nz.co.doltech.gwtls.client.ui.LightSlider::loop,
            slideEndAnimation: this.@nz.co.doltech.gwtls.client.ui.LightSlider::slideEndAnimation,
            pause: this.@nz.co.doltech.gwtls.client.ui.LightSlider::pause,
            keyPress: this.@nz.co.doltech.gwtls.client.ui.LightSlider::keyPress,
            controls: this.@nz.co.doltech.gwtls.client.ui.LightSlider::controls,
            prevHtml: this.@nz.co.doltech.gwtls.client.ui.LightSlider::prevHtml,
            nextHtml: this.@nz.co.doltech.gwtls.client.ui.LightSlider::nextHtml,
            rtl: this.@nz.co.doltech.gwtls.client.ui.LightSlider::rtl,
            adaptiveHeight: this.@nz.co.doltech.gwtls.client.ui.LightSlider::adaptiveHeight,
            vertical: this.@nz.co.doltech.gwtls.client.ui.LightSlider::vertical,
            verticalHeight: this.@nz.co.doltech.gwtls.client.ui.LightSlider::verticalHeight,
            vThumbWidth: this.@nz.co.doltech.gwtls.client.ui.LightSlider::vThumbWidth,
            thumbItem: this.@nz.co.doltech.gwtls.client.ui.LightSlider::thumbItem,
            pager: this.@nz.co.doltech.gwtls.client.ui.LightSlider::pager,
            gallery: this.@nz.co.doltech.gwtls.client.ui.LightSlider::gallery,
            galleryMargin: this.@nz.co.doltech.gwtls.client.ui.LightSlider::galleryMargin,
            thumbMargin: this.@nz.co.doltech.gwtls.client.ui.LightSlider::thumbMargin,
            currentPagerPosition: this.@nz.co.doltech.gwtls.client.ui.LightSlider::currentPagerPosition,
            enableTouch: this.@nz.co.doltech.gwtls.client.ui.LightSlider::enableTouch,
            enableDrag: this.@nz.co.doltech.gwtls.client.ui.LightSlider::enableDrag,
            freeMove: this.@nz.co.doltech.gwtls.client.ui.LightSlider::freeMove,
            swipeThreshold: this.@nz.co.doltech.gwtls.client.ui.LightSlider::swipeThreshold,
            responsive: this.@nz.co.doltech.gwtls.client.ui.LightSlider::responsive,
            // Events
            onBeforeStart: function ($el) {
                that.@nz.co.doltech.gwtls.client.ui.LightSlider::onBeforeStart(*)($el);
            },
            onSliderLoad: function ($el) {
                that.@nz.co.doltech.gwtls.client.ui.LightSlider::onSliderLoad(*)($el);
            },
            onBeforeSlide: function ($el, scene) {
                that.@nz.co.doltech.gwtls.client.ui.LightSlider::onBeforeSlide(*)($el);
            },
            onAfterSlide: function ($el, scene) {
                that.@nz.co.doltech.gwtls.client.ui.LightSlider::onAfterSlide(*)($el);
            },
            onBeforeNextSlide: function ($el, scene) {
                that.@nz.co.doltech.gwtls.client.ui.LightSlider::onBeforeNextSlide(*)($el);
            },
            onBeforePrevSlide: function ($el, scene) {
                that.@nz.co.doltech.gwtls.client.ui.LightSlider::onBeforePrevSlide(*)($el);
            }
        });
    }-*/;
}
