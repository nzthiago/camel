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

import java.util.Map;

public abstract class EventGridTopicCredentials {

    /**
     * Tries to determine the event grid credentials from a collection of name/value pairs.
     * 
     * @param settings
     *            A <code>Map</code> object of the name/value pairs that represent the settings to use to configure
     *            the credentials.
     *            <p>
     *            Include a topic endpoint with a topic key (specifying values for
     *            {@link EventGridServiceConstants#TOPIC_ENDPOINT} and {@link EventGridServiceConstants#    String TOPIC_KEY = "TopicKey";} )
     * 
     * @return A {@link EventGridTopicCredentials} object representing the storage credentials determined from the name/value
     *         pairs.
     * 
     */
    protected static EventGridTopicCredentials tryParseCredentials(final Map<String, String> settings) {
        final String topicEndpoint = settings.get(EventGridServiceConstants.TOPIC_ENDPOINT) != null ?
                settings.get(EventGridServiceConstants.TOPIC_ENDPOINT) : null;

        final String topicKey = settings.get(EventGridServiceConstants.TOPIC_KEY) != null ?
        settings.get(EventGridServiceConstants.TOPIC_KEY) : null;

        if (topicEndpoint != null && topicKey != null) {
            return new EventGridTopicCredentialsEndpointAndKey(topicEndpoint, topicKey);
        }

        return null;
    }
    
}
