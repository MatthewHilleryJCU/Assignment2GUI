package com.codebind;
import java.util.EventListener;
/**
 * Created by matt on 18/10/2016.
 */

public interface DetailListener extends EventListener {
    void detailEventOccurred(DetailEvent event);
}
