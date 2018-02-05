# WSDL
* pronounced /ˈwɪz dəl/
* Web Service Description Language
* XML file that describes everything about the web service
  * It's like an interface (does not say anything about implementation)
  * **The idea is:** if someone has this file, they know everything about the web service *(huge benefit of SOAP)*

# Tags
* **definitions** - root tag
* **types** - defines the data types used by the web service
* **message** - defines the data elements for each operation *(method parameters and return values)*
* **portType** - defines the operations that can be performed and the messages involved *(like an interface)*
* **binding** - defines the protocol and data format for each port type

# References
* [WSDL](https://www.w3schools.com/xml/xml_wsdl.asp)
