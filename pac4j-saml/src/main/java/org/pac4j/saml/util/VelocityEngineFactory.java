/*
  Copyright 2012 -2014 Michael Remond

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
 */

package org.pac4j.saml.util;

import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.log.JdkLogChute;
import org.pac4j.core.exception.TechnicalException;

import java.util.Properties;

/**
 * Factory returning a well configured {@link VelocityEngine} instance required for
 * generating an HTML form used to POST SAML messages.
 * 
 * @author Michael Remond
 *
 */
public class VelocityEngineFactory {

    public static VelocityEngine getEngine() {

        try {

            final Properties props =
                    new Properties(net.shibboleth.utilities.java.support.velocity.VelocityEngine.getDefaultProperties());
            final VelocityEngine velocityEngine = net.shibboleth.utilities.java.support.velocity.VelocityEngine
                    .newVelocityEngine(props);
            velocityEngine.setProperty(RuntimeConstants.ENCODING_DEFAULT, "UTF-8");
            velocityEngine.setProperty(RuntimeConstants.OUTPUT_ENCODING, "UTF-8");
            velocityEngine.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
            velocityEngine.setProperty(RuntimeConstants.RUNTIME_LOG_LOGSYSTEM, new JdkLogChute());
            return velocityEngine;
        } catch (Exception e) {
            throw new TechnicalException("Error configuring velocity", e);
        }

    }

}
