UseCase :

There are 10K customers login-to the system and 
minimum 5 agents to handle them for doing their video KYC for baking system .
Each agent is allowed to take the KYC session for 15 minutes.


How would you handle this situation ?
1)Scale the agent - but that is still restricted till 10 
so even if its 10 still not possible for 10k to handle 

2)Give the available time slots for the particular date to customers 
Question:
How would you difference the booked time slots and available time slots ?
1)Can we store all the time slots in DB - being they are constants ?

Problem here - All the timeslots cannot be stored in DB as they will be huge from 8 to 6 pm
considering 15 minutes timeslot for each .

So for 8 to 12 pm - it will have 16 time slots thats not a good design 

Solution:
Maintain only booked time slots for the date in database
that would save the huge cost 

Now how to get the available timeslots ?
total timeslots - db timeslots = delta
So delta is the available timeslots 