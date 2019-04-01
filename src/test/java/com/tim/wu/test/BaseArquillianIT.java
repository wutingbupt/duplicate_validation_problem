package com.tim.wu.test;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.FileAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.resolver.api.maven.Maven;
import org.junit.Rule;
import org.junit.rules.RuleChain;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.junit.runner.RunWith;

import java.io.File;
import java.net.URL;


@RunWith(Arquillian.class)
public abstract class BaseArquillianIT {


    @ArquillianResource
    protected URL baseURL;


    @Rule
    public TestRule afterWithFailedInformation = RuleChain.emptyRuleChain()
            .around(new TestWatcher() {
                @Override
                protected void failed(Throwable e, Description description) {
                }
            });

    @Deployment(testable = false)
    public static Archive createDeployment() {

        WebArchive archive = ShrinkWrap.create(WebArchive.class, "duplication-test.war");

        File[] libs = Maven.resolver()
                .loadPomFromFile("pom.xml")
                .importRuntimeAndTestDependencies().resolve()
                .withTransitivity().as(File.class);

        archive.addPackages(true, "com.tim.wu.test"); //dont import common or else we will get ambigious dependencies...

        archive.addAsWebInfResource(new FileAsset(new File("src/test/java/resources/beans.xml")), "beans.xml"); //this is found
        archive.addAsWebInfResource(new FileAsset(new File("src/test/java/resources/project-defaults.yml")), "classes/project-defaults.yml"); //this is found

        archive.addAsLibraries(libs);

        //System.out.println(archive.toString(true));

        return archive;
    }

    protected String taskURL() {
        return this.baseURL.toExternalForm();
    }

}
