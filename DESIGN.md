# Design Decision

In addressing this coding challenge, the following considerations were taken:

1) Toy Robot should be interchangeable with other robots, hence the use of the Robot interface. All Robot implementations 
   should be able to deal with the commands (PLACE, MOVE etc) as well as having a receiver for those commands.
2) Command pattern was used to imitate how a robot would work in real life. A user would issue commands. It is the job 
   of the robot to receive those command and handle them accordingly. Commands are nothing but signals and should not 
   contain a lot of logic.
3) Toy robot is aware of the table once it is created. Ideally, it shouldn’t have knowledge of the table until it is 
   placed on the table. However, such approach might complicate the code unnecessarily.
4) Table could be a singleton, since there should ever only be one table at a time. However, this was not included as 
   there was no substantial benefit of introducing such pattern.