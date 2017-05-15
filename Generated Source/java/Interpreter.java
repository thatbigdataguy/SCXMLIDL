interface Interpreter {
void fromUri (URL uri);
void step ();
void cancel ();
String getInterpreterState ();
void addMonitor (Monitor m);
void addMonitor (MonitorImpl m);
void addMonitor (MonitorListener m);
void addEventToQueue (Event e);
void raiseEvent (Event e);

};
Now Lua
