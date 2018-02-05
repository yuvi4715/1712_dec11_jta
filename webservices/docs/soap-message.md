# SOAP Message
* Defines what goes in requests/responses

# Tags
* **envelope** - root tag
* **header** - metadata *(optional)*
* **body** - the data being sent or received
* **fault**
  * child of **body**
  * defines an error/exception that occurred

# Note
* Do not confuse **header** and **body** with the HTTP headers and body
  * The entire SOAP message goes inside the HTTP request/response body
  * Remember we do not have to use the HTTP protocol
