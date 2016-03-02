package com.edc4it

import javax.inject.Inject

import org.apache.camel.CamelContext
import org.apache.camel.cdi.ContextName
import org.apache.camel.scala.dsl.builder.{RouteBuilder, ScalaRouteBuilder}

/**
  * todo
  */
@ContextName("myJettyCamel")
class JettyRoute  extends RouteBuilder {


  "jetty:http://0.0.0.0:8080/camel/" ==> {

    to( "amq:DemoQueue?exchangePattern=InOnly" )
    choice {
      when(header("name")).transform(simple("Hello ${header.name} I am ${sysenv.HOSTNAME} how are you?"))
      otherwise.transform(constant("Add a name parameter to uri, eg ?name=foo"))
    }

  }

}
