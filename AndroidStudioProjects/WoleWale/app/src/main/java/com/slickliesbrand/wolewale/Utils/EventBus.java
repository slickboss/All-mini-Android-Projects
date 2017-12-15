package com.slickliesbrand.wolewale.Utils;

import com.squareup.otto.Bus;

/**
 * Created by SLICKBOSS on 7/6/2016.
 */
public class EventBus extends Bus {
    private static final EventBus bus = new EventBus();
    public static Bus getInstance() {return bus; }


    private EventBus() {}
}
