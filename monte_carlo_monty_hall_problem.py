"""
The Monty Hall Problem: Suppose you are on a game show, and you have the choice of picking one of three doors: 
Behind one door is a car; behind the other doors, goats. You pick a door, let’s say door 1, and the host, 
who knows what’s behind the doors, opens another door, say door 3, which has a goat. The host then asks you: 
do you want to stick with your choice or choose another door? Is it to your advantage to switch your choice of door?
"""

"""
Based on probability, it turns out it is to our advantage to switch the doors. Let’s find out how:

Initially, for all three doors, the probability (P) of getting the car is the same (P = 1/3).

Now assume that the contestant chooses door 1. Next, the host opens the third door, which has a goat.

Next, the host asks the contestant if he/she wants to switch the doors. We can see that after the host opens 
door 3, the probability of the last two doors of having a car increases to 2/3. 

Now we know that the third door has a goat, the probability of the second door having a car increases to 2/3. Hence, it is more 
advantageous to switch the doors. 
"""

#Import required libraries :
import random
import matplotlib.pyplot as plt

#We are going with 3 doors :
#1 - Car
#2 - Goats
doors = ["goat","goat","car"]

#Empty lists to store probability values :
switch_win_probability = []
stick_win_probability = []

plt.axhline(y=0.66666, color='r', linestyle='-')
plt.axhline(y=0.33333, color='g', linestyle='-')

#Monte_Carlo Simulation :
def monte_carlo(n):
    
    #Calculating switch and stick wins :
    switch_wins = 0
    stick_wins = 0
    
    for i in range(n):
    
        #Randomly placing the car and goats behind the three doors :
        random.shuffle(doors) 
        
        #Contestant's choice :
        k = random.randrange(2)  

        #If the contestant doesn't get car :
        if doors[k] != 'car': 
            switch_wins += 1
            
        #If the contestant got car :
        else: 
            stick_wins += 1

        #Updating the list values :
        switch_win_probability.append(switch_wins/(i+1))
        stick_win_probability.append(stick_wins/(i+1))
        
        #Plotting the data :
        plt.plot(switch_win_probability)
        plt.plot(stick_win_probability)
        
    #Print the probability values :
    print('Winning probability if you always switch:',switch_win_probability[-1])
    print('Winning probability if you always stick to your original choice:', stick_win_probability[-1])


#Calling the function :
monte_carlo(1000)

plt.show()
