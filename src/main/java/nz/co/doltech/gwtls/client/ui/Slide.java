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
import com.google.gwt.uibinder.client.UiConstructor;
import com.google.gwt.user.client.ui.Image;
import nz.co.doltech.gwtls.client.base.ComplexWidget;

public class Slide extends ComplexWidget {

    private final Image image;

    @UiConstructor
    public Slide(String imageUrl) {
        this(imageUrl, null);
    }

    public Slide(String imageUrl, String thumbUrl) {
        setElement(Document.get().createLIElement());
        getElement().setClassName("lslide");

        if(thumbUrl != null) {
            setThumbUrl(thumbUrl);
        }
        image = new Image(imageUrl);
        add(image);
    }

    public void setThumbUrl(String thumbUrl) {
        getElement().setAttribute("data-thumb", thumbUrl);
    }

    public Image getImage() {
        return image;
    }
}
