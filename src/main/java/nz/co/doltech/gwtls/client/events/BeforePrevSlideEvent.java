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
package nz.co.doltech.gwtls.client.events;

import com.google.gwt.event.shared.GwtEvent;
import nz.co.doltech.gwtls.client.ui.JsLightSlider;
import nz.co.doltech.gwtls.client.ui.LightSlider;

/**
 * Executes immediately before each "Prev" slide transition.
 *
 * @author Ben Dol
 */
@SuppressWarnings({"unchecked"})
public class BeforePrevSlideEvent extends GwtEvent<BeforePrevSlideHandler> {

    public static void fire(LightSlider source, JsLightSlider impl) {
        source.fireEvent(new BeforePrevSlideEvent(source, impl));
    }

    private static final Type<BeforePrevSlideHandler> TYPE = new Type<>();

    public static Type<BeforePrevSlideHandler> getType() {
        return TYPE;
    }

    private final LightSlider source;
    private final JsLightSlider impl;

    private BeforePrevSlideEvent(LightSlider source, JsLightSlider impl) {
        this.source = source;
        this.impl = impl;
    }

    @Override
    public LightSlider getSource() {
        return source;
    }

    public JsLightSlider getImpl() {
        return impl;
    }

    @Override
    public Type<BeforePrevSlideHandler> getAssociatedType() {
        return (Type) TYPE;
    }

    @Override
    protected void dispatch(final BeforePrevSlideHandler handler) {
        handler.onBeforePrevSlide(this);
    }
}
