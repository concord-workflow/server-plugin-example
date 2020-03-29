package ca.ibodrov.concord.server.plugin.example;

/*-
 * *****
 * Concord
 * -----
 * Copyright (C) 2020 Ivan Bodrov
 * -----
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * =====
 */

import org.sonatype.siesta.Resource;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * An example API endpoint.
 */
@Named
@Singleton
@Path("/api/example")
public class ExampleResource implements Resource {

    private final ExampleDao dao;

    @Inject
    public ExampleResource(ExampleDao dao) {
        this.dao = dao;
    }

    /**
     * An example API method. Returns the number of registered users.
     */
    @GET
    @Path("/countUsers")
    @Produces(MediaType.TEXT_PLAIN)
    public int countUsers() {
        return dao.countUsers();
    }
}
