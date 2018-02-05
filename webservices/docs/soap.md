# SOAP
* Simple Object Access Protocol
* Type of Web Service (describes how two applications can exchange data)
  * Remember the key terms **expose** and **consume**
* Largely XML based
  * WSDL
  * SOAP Message
* Usually client and server talk over HTTP (but they do not have to)
* Very rigid in the format of requests and responses
  * So if you get good with SOAP, you know exactly what each request and response will look like

# Compare with REST
* REpresentational State Transfer
* Does not specify what requests/responses contain (could be XML, JSON, YAML, ...)
* Does not have a rigid definition (the only way you know what a Restful Web Service does is from documentation)
* Because it's so loose, we can be opinionated in our design (this also means it's easier to mess up)

# Comparison Conclusion
* At the end of the day, we're sending requests and getting back responses
* This is still the client/server architecture that you're used to
* REST has seemingly taken over for its ease of use and ability to use JSON
  * This is especially nice because we make a lot of requests from browsers (JavaScript and JSON play nicely together)

# Ways to create a SOAP web service
1. contract first
-  contract last

We will learn that the WSDL is a very important file.  Common names for WSDL include *endpoint interface* and *contract*.  So **contract first** is when we create the contract first *(the XML file)* and then we define the implementation *(the code)*.

# Useful tool
* [SOAP UI](https://www.soapui.org/getting-started/installing-soapui.html) is like Postman but has extra support for testing SOAP web services

# Note
* Do not think that all clients are browsers (anything that sends a request is considered a client)
* Remember that web services (SOAP and REST) are language agnostic
