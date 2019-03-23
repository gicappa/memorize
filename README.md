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
showing its needs of refactoring. The test is showing all the limit
of having to read a standard input without passing in any way the 
possible questions but expecting a specific output and giving a 
specific input. This test is screaming for a refactoring of the code 
that will end up in a refactoring/ease of the test itself.

## The first real refactoring
Now that I have a test the application may be refactored for real. 
The first question I make to myself is: should I use a functional style
or an object oriented style? In the first case I should pass some 
functions to accomplish to the different task of selecting a 
quiz to present and check for the answers. In the second case some 
objects to accomplish the task hiding the implementation details
with encapsulation. I'll start with the OO style I'm more comfortable
with. 
In the refactoring I started extracting the Quizzes from the App class.
Now the app class will obtail the quizzes from the constructor.

## Continuing with the refactoring
I continued the refactoring trying to proceed by baby steps. Next 
step is to extract the method ``askQuiz`` in order to start splitting the responsibilities.
Next step has been to overcome the "Primitive Obsession" of using a 
boolean to express the result of a quiz: the ``askQuiz`` will now return
a ``Result`` enum that may have a ``CORRECT`` or ``WRONG`` result.
These refactoring allowed me also to create new tests because in the 
process we started decoupling differenr parts of the application.

## Splitting responsibilities
We started from a connected architecture so all the responsibilities 
are glued together in the same place. It's time to apply the Single
Responsibility Principle (SRP) and start extracting the 
responsibilities from the application. While extracting we'll move 
also the test that we can move in a separate test case.
The first responsibility to split is the configuration and start 
of a quiz session of the App from the actual test session execution.
We decided to extract the QuizSession object that contains the ``start()``
method that accept a list of quizzes and that will executes all of them.
We also moved all the methods related to the quiz execution to this new 
class. 
Now App just create quizzes and QuizSession and then run the session.
The last step is to move the tests to a new QuizSessionTest class. 

## Applying SRP to the QuizSession class
