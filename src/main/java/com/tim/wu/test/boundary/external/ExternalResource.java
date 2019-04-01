package com.tim.wu.test.boundary.external;

import javax.enterprise.context.RequestScoped;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@RequestScoped
@Path("/v1/hello")
public class ExternalResource {

    private static final String RETRY_AFTER = "Retry-After";



/*
    @Path("/normal")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response get() {
        Hello hello = new Hello();
        hello.setMsg("hello world");
        return Response.ok().entity(hello).build();
    }


    @Path("/realasync")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public void getRealAsync(@Suspended final AsyncResponse response) throws InterruptedException {

        response.setTimeoutHandler(this::buildTimeoutResponse);
        response.setTimeout(10, TimeUnit.SECONDS);
        Hello hello = new Hello();
        hello.setMsg("hello world");
        response.resume(hello);
    }
*/

    @Path("/beanvalidator")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response multiBeanValidator(@Valid MyBean myBean){
        System.out.println("starting...");
        MyBean bean = new MyBean();
        bean.setHello("xxx");
        return Response.noContent().build();
    }

/*
    public static String crunchifyGenerateThreadDump() {
        final StringBuilder dump = new StringBuilder();
        final ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        final ThreadInfo[] threadInfos = threadMXBean.getThreadInfo(threadMXBean.getAllThreadIds(), 100);
        for (ThreadInfo threadInfo : threadInfos) {
            dump.append('"');
            dump.append(threadInfo.getThreadName());
            dump.append("\" ");
            final Thread.State state = threadInfo.getThreadState();
            dump.append("\n   java.lang.Thread.State: ");
            dump.append(state);
            final StackTraceElement[] stackTraceElements = threadInfo.getStackTrace();
            for (final StackTraceElement stackTraceElement : stackTraceElements) {
                dump.append("\n        at ");
                dump.append(stackTraceElement);
            }
            dump.append("\n\n");
        }
        return dump.toString();
    }

    static class MyRunnable implements Runnable {

        AsyncResponse response;

        public MyRunnable(AsyncResponse response) {
            this.response = response;
        }

        @Override
        public void run() {

            System.out.println("hello world");
            //Thread.sleep(4000);
            System.out.println("????");
            Hello hello = new Hello();
            hello.setMsg("hello world");
            response.resume(Response.ok().entity(hello).build());
        }
    }

    protected void buildTimeoutResponse(AsyncResponse ar) {

        Response response = Response.status(Response.Status.SERVICE_UNAVAILABLE).
                header(RETRY_AFTER, 10).
                entity(UcmError.builder().code(UcmCommonErrorCodes.UCM_TIMEOUT_ERROR).
                        status(Response.Status.SERVICE_UNAVAILABLE.getStatusCode()).
                        message("server is overloaded").build())
                .build();

        ar.resume(response);
    }
*/

}
