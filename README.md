# Concord Server Plugin Example

An example plugin for [Concord](https://concord.walmartlabs.com/) server.

Demonstrates a couple of concepts: 
- adding a new JAX-RS endpoint;
- using [testcontainer-concord](https://github.com/concord-workflow/testcontainers-concord) to test the plugin.

## Usage

Requires latest Concord Docker images built from master.

- compile with `mvn package`;
- copy `target/server-plugin-example-*.jar` into an `ext` directory somewhere on the filesystem;
- mount the `ext` directory to the Concord Server Docker container:
```
docker run \
...
-v "/path/to/host/ext:/opt/concord/server/ext:ro" \
...
walmartlabs/concord-server
```

