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

import ca.ibodrov.concord.testcontainers.Concord;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.ResponseBody;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PluginTest {

    @Rule
    public Concord concord = new Concord()
            .serverClassesDirectory("target/classes");

    @Test
    public void test() throws Exception {
        OkHttpClient client = concord.apiClient().getHttpClient();

        Request request = new Request.Builder()
                .url(concord.apiUrlPrefix() + "/api/example/countUsers")
                .addHeader("Authorization", concord.adminApiToken())
                .build();

        Response response = client.newCall(request).execute();
        assertEquals(200, response.code());
        try (ResponseBody body = response.body()) {
            assertEquals("5", body.string()); // 5 default users
        }
    }
}
