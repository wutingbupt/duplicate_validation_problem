package com.tim.wu.test.boundary.version;

import org.wildfly.swarm.spi.runtime.annotations.ConfigurationValue;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/version")
@ApplicationScoped
public class VersionResource {

    @Inject
    @ConfigurationValue("service.sw.version")
    String swVersion;

    @Inject
    @ConfigurationValue("service.sw.name")
    String swName;

    @Inject
    @ConfigurationValue("service.sw.pom.parent-version")
    String pomParentVersion;

    @Inject
    @ConfigurationValue("service.sw.container.image")
    String containerImage;

    @Inject
    @ConfigurationValue("service.sw.git.branch")
    String gitBranch;

    @Inject
    @ConfigurationValue("service.sw.git.tags")
    String gitTags;

    @Inject
    @ConfigurationValue("service.sw.git.build.host")
    String gitBuildHost;

    @Inject
    @ConfigurationValue("service.sw.git.build.time")
    String gitBuildTime;

    @Inject
    @ConfigurationValue("service.sw.git.build.user.email")
    String gitBuildUserEmail;

    @Inject
    @ConfigurationValue("service.sw.git.build.user.name")
    String gitBuildUserName;

    @Inject
    @ConfigurationValue("service.sw.git.commit.id")
    String gitCommitId;

    @Inject
    @ConfigurationValue("service.sw.git.commit.time")
    String gitCommitTime;

    @Inject
    @ConfigurationValue("service.sw.git.commit.user.email")
    String gitCommitUserEmail;

    @Inject
    @ConfigurationValue("service.sw.git.commit.user.name")
    String gitCommitUserName;

    @Inject
    @ConfigurationValue("service.sw.git.commit.message.short")
    String gitCommitMessageShort;

    public VersionResource() {
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response get() throws Exception {

        return Response.ok().entity("1").build();
    }
}
