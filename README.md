# Overview
SCXMLIDL is the first step towards standardization of [SCXML][1] interpreter APIs. SCXMLIDL covers a small subset of API that can be mapped to different current SCXML interpreter implementations. It lets you generate code for the targeted interpreter implementation by generating code from a given webIDL. 

Currently  SCXMLIDL supports [Commons SCXML][2], [uSCXML][3] and [LXSC][4]

| Project | Language |Supported by SCXMLIDL |
|---------|---------|---------|
| [Commons SCXML](https://commons.apache.org/proper/commons-scxml/) | Java | Yes |
| [uSCXML](https://github.com/tklab-tud/uscxml) | C++ | Yes |
| [LXSC](https://github.com/Phrogz/LXSC) | Lua | Yes |
| [SCION](https://github.com/jbeard4/SCION) | JavaScript | No |
| [JSSCxml](https://jsscxml.org/) | JavaScript| No |

# Table of Contents
* [Usage](#usage)
  * [The Basics](#the-basics)
* [Examples](#examples)
  * [JavaSample Project](#the-basics)
  * [C++Sample Project](#the-basics)
  * [LuaSample Project](#the-basics)
* [Future Work (TODO)](#futurework)

  
## Usage
### The Basics
## Input
### webIDL
## Output
### Generated Files
#### Java
#### C++
#### Lua
## API
### Constructor
* var interpreter = new Interpreter()
### Methods of SCXML interpreter instances
* interpreter.setStateMachine ()
* interpreter.addMonitor()
* interpreter.triggerEvent(Event e)
* interpreter.triggerEvents()
* interpreter.allStateIds()
* interpreter.isActiveState(stateId)
* interpreter.getInterpreterState()
### Callbacks as the Machine Changes
* interpreter.onExit()
* interpreter.onTransition()
* interpreter.onEntry()

## Examples

## Future Work

* Support for Data Model 
* Support for Custom Executable Content



[1]: http://www.w3.org/TR/scxml/
[2]: https://commons.apache.org/proper/commons-scxml/
[3]: https://github.com/tklab-tud/uscxml
[4]: https://github.com/Phrogz/LXSC

