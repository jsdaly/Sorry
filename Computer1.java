
import java.util.*;

public class Computer1{
   cs205_SorryCards card = new cs205_SorryCards();
   Color color = Color.RED;
   Pawn pieceOne = new Pawn(color);
   Pawn pieceTwo = new Pawn(color);
   Pawn pieceThree = new Pawn(color);
   Pawn pieceFour = new Pawn(color);
   Board aSpace = new Board();
   //SquareSpace space= startSpace.getSpace()//needs index though
   RoundSpace starts = aSpace.getStart(color);//holds space of start for color RED
   ArrayList<Pawn> allPawns = new ArrayList<Pawn>();
   
   int move;
   
   protected Computer1(){
   allPawns.add(pieceOne);
   allPawns.add(pieceTwo);
   allPawns.add(pieceThree);
   allPawns.add(pieceFour);
   }
   
   public void moves(){
   int cards = card.draw();
      if (cards==1){
         if (starts.occupied() == true){
            //move pawn froms start
           }
         else if (starts.occupied() == false){
           chooseMove(cards);
           }}
           
      if (cards ==2){
         if (starts.occupied() == true){
           //move pawn from home
           }
         else if (starts.occupied() == false){
           chooseMove(cards);
            }}
      
      if (cards==3){
         if ((starts.occupiedBy(pieceOne))&&(starts.occupiedBy(pieceTwo))&&
               (starts.occupiedBy(pieceThree))&&(starts.occupiedBy(pieceFour)) == true){
          //cant move
           }
         else{
             chooseMove(cards);
            
           }}
           
      if (cards==4){
          if ((starts.occupiedBy(pieceOne))&&(starts.occupiedBy(pieceTwo))&&
               (starts.occupiedBy(pieceThree))&&(starts.occupiedBy(pieceFour)) == true){
          //cant move
           }
         else{
             chooseMove(-4);
            
            }}
           
      if (cards==5){ 
         if ((starts.occupiedBy(pieceOne))&&(starts.occupiedBy(pieceTwo))&&
               (starts.occupiedBy(pieceThree))&&(starts.occupiedBy(pieceFour)) == true){
          //cant move
           }
         else{
             chooseMove(cards);
            
           }}
           
      if (cards==7){
          if ((starts.occupiedBy(pieceOne))&&(starts.occupiedBy(pieceTwo))&&
               (starts.occupiedBy(pieceThree))&&(starts.occupiedBy(pieceFour)) == true){
          //cant move
           }
         else{
            chooseMove(cards);
            
            }}
            
      if (cards==8){
          if ((starts.occupiedBy(pieceOne))&&(starts.occupiedBy(pieceTwo))&&
               (starts.occupiedBy(pieceThree))&&(starts.occupiedBy(pieceFour)) == true){
          //cant move
           }
         else{
            chooseMove(cards);
            
            }}
            
      if (cards==10){
          if ((starts.occupiedBy(pieceOne))&&(starts.occupiedBy(pieceTwo))&&
               (starts.occupiedBy(pieceThree))&&(starts.occupiedBy(pieceFour)) == true){
          //cant move
           }
         else{
             chooseMove(cards);
            
            }}
            
      if (cards==11){
           if ((starts.occupiedBy(pieceOne))&&(starts.occupiedBy(pieceTwo))&&
               (starts.occupiedBy(pieceThree))&&(starts.occupiedBy(pieceFour)) == true){
          //cant move
           }
         else{
             chooseMove(cards);
            
            }}
            
       if (cards==12){
         if ((starts.occupiedBy(pieceOne))&&(starts.occupiedBy(pieceTwo))&&
               (starts.occupiedBy(pieceThree))&&(starts.occupiedBy(pieceFour)) == true){
          //cant move
           }
         else{
            chooseMove(cards);
                        }}      
           
       if (cards==13){if (starts.occupied() == true){
         
            
           }
         else if (starts.occupied() == false){
           }}
   
   
   
   
   }
   public void chooseMove(int card){
   //call on method that pulls index of pawn and stores it in int called pawnIndex
    boolean flag = true; 
    while(flag = true){
      

      for(int i = 0; i < allPawns.size(); i++){
      
      
         Space pawn = allPawns.get(i).getSpace();//Space
         
                              
         int pawnIndex = ((SquareSpace)pawn).getIndex();
         int total = pawnIndex + card;
       //by a slide
         if ((total % 15 == 9)||(total % 15 == 1)){
            SquareSpace moveTo = aSpace.getSpace(total);
            Pawn chosen = (Pawn)allPawns.get(i);
            aSpace.movePawn(chosen, moveTo);
            break;
      
      }
    //near safety
         if (total%15 == 2){
            SquareSpace moveTo = aSpace.getSpace(total);
            Pawn chosen = (Pawn)allPawns.get(i);
            aSpace.movePawn(chosen, moveTo);
            break;
      
      }
   //space occupied
         SquareSpace givenSpace = aSpace.getSpace(total);
         if (givenSpace.occupied() == true){
            Pawn otherPawn = givenSpace.getOccupant();
            if(otherPawn.getColor() == color){}
            if(otherPawn.getColor() != color){
               Pawn chosen = (Pawn)allPawns.get(i);
               aSpace.movePawn(chosen, givenSpace);
               break;
   }
   
   }}}
   Random rand = new Random();
   int n = rand.nextInt(4); 
   Pawn chosen = allPawns.get(n);
   Space pawn = allPawns.get(n).getSpace();//Space
   int pawnIndex = ((SquareSpace)pawn).getIndex();
   int total = pawnIndex + card;
   SquareSpace moveTo = aSpace.getSpace(total);
   aSpace.movePawn(chosen, moveTo);

     
 
   
  }
  }