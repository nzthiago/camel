/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.camel.component.azure.eventgrid;

import org.apache.camel.Endpoint;
import org.apache.camel.Exchange;
import org.apache.camel.impl.DefaultProducer;
import org.apache.camel.util.ObjectHelper;
import org.apache.camel.util.URISupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A Producer which send events to an Event Grid topic
 */
public class EventGridServiceProducer extends DefaultProducer {

    private static final Logger LOG = LoggerFactory.getLogger(EventGridServiceProducer.class);

    public EventGridServiceProducer(final Endpoint endpoint) {
        super(endpoint);
    }

    @Override
    public void process(final Exchange exchange) throws Exception {
        EventGridServiceOperations operation = determineOperation(exchange);
        if (ObjectHelper.isEmpty(operation)) {
            operation = EventGridServiceOperations.sendEvent;
        } else {
            switch (operation) {
            case sendEvent:
                sendEvent(exchange);
                break;    
            default:
                throw new IllegalArgumentException("Unsupported operation");
            }
        }        
    }

    private EventGridServiceOperations determineOperation(Exchange exchange) {
        EventGridServiceOperations operation = exchange.getIn().getHeader(EventGridServiceConstants.OPERATION, 
                                                                            EventGridServiceOperations.class);
        if (operation == null) {
            operation = getConfiguration().getOperation();
        }
        return operation;
    }

    protected EventGridServiceConfiguration getConfiguration() {
        return getEndpoint().getConfiguration();
    }

    @Override
    public String toString() {
        return "EventGridServiceProducer[" + URISupport.sanitizeUri(getEndpoint().getEndpointUri()) + "]";
    }

    @Override
    public EventGridServiceEndpoint getEndpoint() {
        return (EventGridServiceEndpoint) super.getEndpoint();
    }
    
    private void sendEvent(Exchange exchange) throws Exception {
        LOG.trace("Sending an event");
    }

}
