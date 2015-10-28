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
package nz.co.doltech.gwtls.client.options;

import com.google.gwt.core.client.JavaScriptObject;

public class Breakpoint extends JavaScriptObject {

    protected Breakpoint() {}

    public native final void setBreakpoint(int breakpoint) /*-{
        this.breakpoint = breakpoint;
    }-*/;

    public native final void setSettings(Setting settings) /*-{
        this.settings = settings;
    }-*/;

    public static Breakpoint create(int startPoint) {
        Breakpoint breakpoint = JavaScriptObject.createObject().cast();
        breakpoint.setBreakpoint(startPoint);
        breakpoint.setSettings(Setting.create());
        return breakpoint;
    }
}
