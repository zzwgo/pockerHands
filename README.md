#rule:

* if playerA win the game, then print  1;
* if playerB win the game, then print 2;
* if the game is draw, then print 3;

------

# Test Case:
```
1. 
given:(2H),(3D)
when:call excute method
then:2

2.
given:(KH),(KD)
when:call excute method
then:3
---------------------------------------------
3.
given:(4H,5C,8C,9C,AD),(2H,3D,5S,9C,KD)
when:call excute method
then:1

4.
given:(2H,3D,5S,9C,AC),(4H,5C,8C,9D,AD)
when:call excute method
then:3
---------------------------------------------
5.
given:(2H,3D,5S,9C,AC),(4H,5C,8C,10D,10H)
when:call excute method
then:2

6.
given:(2H,3D,5S,9C,9H),(4H,5C,8C,10D,10H)
when:call excute method
then:2

7.
given:(2H,2D,5S,9C,AC),(2S,2C,8C,9C,KD)
when:call excute method
then:1

8.
given:(2H,2D,5S,5C,AC),(2S,2C,8C,8H,KD)
when:call excute method
then:2

9.
given:(2H,2D,5H,5D,AC),(2S,2C,5S,5C,KD)
when:call excute method
then:1

10.
given:(2H,2D,5H,5D,KC),(2S,2C,5S,5C,KD)
when:call excute method
then:3
---------------------------------------------
11.
given:(2H,2D,5H,5D,AC),(2S,2C,6S,6C,6D)
when:call excute method
then:2

12.
given:(2H,2D,2S,5D,AC),(3S,3C,6S,6C,6D)
when:call excute method
then:2
---------------------------------------------
13.
given:(2H,2D,2S,9C,AC),(4H,5C,6C,7C,8D)
when:call excute method
then:2

14.
given:(2H,3D,4D,5D,6H),(4H,5C,6C,7C,8D)
when:call excute method
then:2
---------------------------------------------
15.
given:(2S,3D,4D,5D,6S),(2H,5H,6H,7H,9H)
when:call excute method
then:2

16.
given:(2S,3S,7S,9S,10S),(2H,5H,6H,7H,9H)
when:call excute method
then:3
---------------------------------------------
17.
given:(7H,7C,7S,8C,8D),(2S,3S,6S,9S,10S)
when:call excute method
then:1

18.
given:(7H,7C,7S,8C,8D),(2D,2S,2H,5D,5C)
when:call excute method
then:1
---------------------------------------------
19.
given:(7H,7C,7S,7D,8D),(2D,2S,2H,5D,5C)
when:call excute method
then:1

20.
given:(7H,7C,7S,7D,8D),(2C,2H,2S,2D,5C)
when:call excute method
then:1
---------------------------------------------
21.
given:(8C,8H,8S,8D,5C),(2D,3D,4D,5D,6D),
when:call excute method
then:2

22.
given:(3S,4S,5S,6S,7S),(2D,3D,4D,5D,6D),
when:call excute method
then:1

```


