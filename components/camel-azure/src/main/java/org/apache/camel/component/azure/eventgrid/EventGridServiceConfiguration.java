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

import org.apache.camel.spi.UriParam;
import org.apache.camel.spi.UriParams;

@UriParams
public class EventGridServiceConfiguration {

    @UriParam 
    private String topicName;

    @UriParam
    private EventGridTopicCredentials topicCredentials;

    private EventGridEvent event;

    @UriParam(label = "producer", defaultValue = "sendEvent")
    private EventGridServiceOperations operation = EventGridServiceOperations.sendEvent;
    
    public EventGridServiceOperations getOperation() {
        return operation;
    }

    /**
     * Event Grid service operation hint to the producer 
     */
    public void setOperation(EventGridServiceOperations operation) {
        this.operation = operation;
    }

    /**
     * Topic name, required for most operations
     */
    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    /**
     * Event
     */
    public EventGridEvent getevent() {
        return event;
    }

    public void setEvent(EventGridEvent event) {
        this.event = event;
    }

    /**
     * Set the event grid topic credentials
     */
    public void setTopicCredentials(EventGridTopicCredentials credentials) {
        this.topicCredentials = credentials;
    }

    public EventGridTopicCredentials getTopicCredentials() {
        return topicCredentials;
    }
}
    