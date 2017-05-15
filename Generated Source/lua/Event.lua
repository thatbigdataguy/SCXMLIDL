--Meta class

Interpreter = {name=0}
local currentstate
local INITIALIZED, STEPPED = 0, 1
-- Base class method new


function Interpreter:new (o,nam)
 o = o or {}
 setmetatable(o,self)
 self.__index = self
 nam = nam or 0
 local scxml   = io.open(nam):read('*all')
 machine = LXSC:parse(scxml)
 self.name = machine
 currentstate=INITIALIZED
 return o
 end


