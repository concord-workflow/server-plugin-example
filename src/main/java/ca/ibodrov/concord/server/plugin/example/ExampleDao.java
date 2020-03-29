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

import com.walmartlabs.concord.db.AbstractDao;
import com.walmartlabs.concord.db.MainDB;
import org.jooq.Configuration;
import org.jooq.DSLContext;
import org.jooq.impl.DSL;

import javax.inject.Inject;
import javax.inject.Named;

import static com.walmartlabs.concord.server.jooq.tables.Users.USERS;

@Named
public class ExampleDao extends AbstractDao {

    @Inject
    public ExampleDao(@MainDB Configuration cfg) {
        super(cfg);
    }

    public int countUsers() {
        try (DSLContext tx = DSL.using(cfg)) {
            return tx.fetchCount(USERS);
        }
    }
}
