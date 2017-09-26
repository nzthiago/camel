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

import org.apache.camel.Endpoint;
import org.apache.camel.impl.DefaultComponent;

public class EventGridServiceComponent extends DefaultComponent {


    protected Endpoint createEndpoint(String uri, String remaining, Map<String, Object> parameters) throws Exception {
        EventGridServiceConfiguration configuration = new EventGridServiceConfiguration();
        setProperties(configuration, parameters);

        String[] parts = null;
        if (remaining != null) {
            parts = remaining.split("/"); 
        }
        if (parts == null || parts.length < 1) {
            throw new IllegalArgumentException("The topic name must be specified.");
        }
        
        configuration.setTopicName(parts[0]);
        
        checkCredentials(configuration);
        
        EventGridServiceEndpoint endpoint = new EventGridServiceEndpoint(uri, this, configuration);
        setProperties(endpoint, parameters);
        return endpoint;
    }
    
    private void checkCredentials(EventGridServiceConfiguration cfg) {
        EventGridTopicCredentials creds = cfg.getTopicCredentials(); 
        if (creds == null) {
            throw new IllegalArgumentException("Credentials must be specified.");
        }
    }
}
