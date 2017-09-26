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

import org.apache.camel.Component;
import org.apache.camel.Producer;
import org.apache.camel.spi.UriEndpoint;
import org.apache.camel.spi.UriParam;
import org.apache.camel.spi.UriPath;
import org.apache.camel.spi.Metadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.camel.impl.ProcessorEndpoint;

/**
 * The azure-eventgrid component is used generates events to and subscribes to events from the Azure Event Grid Service.
 */
@UriEndpoint(scheme = "azure-eventgrid",
             title = "Azure Event Grid Service", 
             syntax = "azure-eventgrid:topic", 
             producerOnly = true,
             label = "cloud,event,azure")
public class EventGridServiceEndpoint extends ProcessorEndpoint {

    private static final Logger LOG = LoggerFactory.getLogger(EventGridServiceEndpoint.class);

    @UriPath(description = "Topic")
    @Metadata(required = "true")
    private String topic; // to support component docs

    @UriParam
    private EventGridServiceConfiguration configuration;

    public EventGridServiceEndpoint(String uri, Component comp, EventGridServiceConfiguration configuration) {
        super(uri, comp);
        this.configuration = configuration;
    }

    public Producer createProducer() throws Exception {
        LOG.trace("Creating a producer");
        if (getConfiguration().getTopicName() == null) {
            throw new IllegalArgumentException("Topic name must be specified.");
        }
        return new EventGridServiceProducer(this);
    }

    public boolean isSingleton() {
        return true;
    }

    public EventGridServiceConfiguration getConfiguration() {
        return configuration;
    }

    public void setConfiguration(EventGridServiceConfiguration configuration) {
        this.configuration = configuration;
    }

}
