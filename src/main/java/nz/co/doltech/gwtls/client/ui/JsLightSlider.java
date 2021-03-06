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

import com.google.gwt.core.client.JavaScriptObject;

/**
 * Javascript object representing the {@link LightSlider} implementation.
 * This gives access to the javascript public methods.
 */
public class JsLightSlider extends JavaScriptObject {
    protected JsLightSlider() {
    }

    public native final void goToSlide(int slide) /*-{
        this.goToSlide(slide);
    }-*/;

    public native final void goToPrevSlide() /*-{
        this.goToPrevSlide();
    }-*/;

    public native final void goToNextSlide() /*-{
        this.goToNextSlide();
    }-*/;

    public native final void getCurrentSlideCount() /*-{
        this.getCurrentSlideCount();
    }-*/;

    public native final void refresh() /*-{
        this.refresh();
    }-*/;

    public native final void play() /*-{
        this.play();
    }-*/;

    public native final void pause() /*-{
        this.pause();
    }-*/;

    public native final void destroy() /*-{
        this.destroy();
    }-*/;
}