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

import com.microsoft.azure.storage.core.Utility;

/**
 * Represents Event Grid Topic credentials, based on topic endpoint and access key.
 */
public final class EventGridTopicCredentialsEndpointAndKey extends EventGridTopicCredentials {

    private String topicEndpoint;

    private String topicKey;

    /**
     * Creates an instance of the <code>EventGridTopicCredentialsEndpointAndKey</code> class, using the specified topic
     * endpoint and key.
     * 
     * @param topicEndpoint
     *            A <code>String</code> that represents the endpoint of the Event Grid topic.
     * @param topicKey
     *            A <code>String</code> that represent the Event Grid topic access key.
     */
    public EventGridTopicCredentialsEndpointAndKey(final String topicEndpoint, final String topicKey) {
        if (Utility.isNullOrEmptyOrWhitespace(topicEndpoint)) {
            throw new IllegalArgumentException("Invalid topic endpoint.");
        }

        if (Utility.isNullOrEmptyOrWhitespace(topicKey)) {
            throw new IllegalArgumentException("Invalid topic key.");
        }

        this.topicEndpoint = topicEndpoint;
        this.topicKey = topicKey;
    }

    /**
     * Gets the endpoint of the Event Grid topic.
     * 
     * @return A <code>String</code> that contains the endpoint of the Event Grid topic.
     */
    public String getTopicEndpoint() {
        return this.topicEndpoint;
    }

    /**
     * Gets the endpoint of the Event Grid topic access key.
     * 
     * @return A <code>String</code> that contains the endpoint of the Event Grid topic access key.
     */
    public String getTopicKey() {
        return this.topicKey;
    }
    
    /**
     * Sets the Event Grid topic.
     * 
     * @param topicEndpoint
     *          A <code>String</code> that contains the Event Grid topic.
     */
    public void setTopicEndpoint(String topicEndpoint) {
        this.topicEndpoint = topicEndpoint;
    }

    /**
     * Sets the Event Grid topic access key.
     * 
     * @param topicKey
     *          A <code>String</code> that contains the Event Grid topic access key.
     */
    public void setTopicKey(String topicKey) {
        this.topicKey = topicKey;
    }    
}
