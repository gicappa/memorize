# memorize

This application has born to help my daughter to memorize 
some concepts of the primary school: english words, multiplication
tables and so on.

While I started writing the code I thought to myself "it's an easy task, I 
should come up with something working in a small amount of time."

So I fired up IntelliJ IDEA and I started having doubts: should I 
create a gradle/maven project immediately or not? Should I design 
the business logic first? Should I think about the UI first?
What are my inputs? English words are strings while multiplication
tables are number checks: should I already think about an abstraction
over different classes of puzzles?

I understood that even from a very simple requirement and need, even 
before starting the put down any code, the complexity was tremendous.
And the more I was thinking about the practical solution in code terms 
the more I was making up new requirements (statistics of errors, 
reproposing the quizzies that has been wrongly answered, adding 
a gamification to get Emma interested in the test showing a My Little 
Pony character every time she answer correctly all the tests, and so on 
and so forth) 

So I decided to take this small, insignificant and unrequested 
(by my daughter) project as a training to set up a road, using the 
experience on software project I had during almost twenty years of
writing code.

# Day One: Connected skeleton to modularized approach  
Let's start from writing a completely connected application (procedural 
style) with a single class with a main that uses the console to interact
with the user. At the beginning the application will be hard coded 
and plain simple in the structure using only methods and no tests at all
for a very simple task: not loading files but hardcoding one question
and one answer, let's say the simpled MVP possible. The app will display
a string with a question and will wait for an answer. If the answer is 
the string 'correct' then it will show the string OK to the stdout 
otherwise it will be displayed ERROR.

This walking skeleton application will help me to setup the basic I/O 
and to think about the minimum interaction with the user that should be 
set up in an explorative way. Furthermore I don't need test for the moment 
because I still don't know which input and output I'm expecting and 
writing a test would force me to imagine and shape them without any 
real life feed back. 

Since I'm a TDDer, not having a single test makes me uncomfortable, so 
as soon as I have skeleton ready I'll try to cover it with an end to 
end test and I'll start from that one to trigger the TDD of the whole 
architecture.

## The first test
The first end to end test is where the connected application start 
showing its needs of refactoring.
There are hardcoded values that must be passed by the test itself to be testest.  
    
 