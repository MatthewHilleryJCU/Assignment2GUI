package com.codebind;

import java.util.EventObject;

/**
 * Created by matt on 18/10/2016.
 */
public class DetailEvent extends EventObject {

    private String text;
    public DetailEvent(Object source, String text) {
        super(source);

        this.text = text;
    }
    public String getText(){
        return text;
    }
}
