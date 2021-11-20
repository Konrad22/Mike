public class PieceRemover
{
	int counter = 0;
  void takePiece(Gamepiece g)
	{
		g.erase();
		if Turncounter.black
		{
			taken[counter].draw(BLACK);
			BlackPlayer.pieces--;
		}
		else
		{
			taken[counter + 7].draw(WHITE);
			WhitePlayer.pieces--;
		}
		counter++;
	}
}


Gamepiece taken [] = new Gamepiece[13] //0-6 taken by black, 7-13 taken by white
taken[0] = b1;
.
.
.
taken[13] = w6;

//somewhere else?

Gamepiece not_occupied [] = new Gamepiece[41];
Gamepiece w1 = new Gamepiece(); //do this in the Boardmaker somehow?
Gamepiece w2 = new Gamepiece();
Gamepiece w3 = new Gamepiece();
Gamepiece w4 = new Gamepiece();
Gamepiece w5 = new Gamepiece();
Gamepiece w6 = new Gamepiece();
Gamepiece w7 = new Gamepiece();
Gamepiece w8 = new Gamepiece();
Gamepiece w9 = new Gamepiece();
Gamepiece b1 = new Gamepiece();
Gamepiece b2 = new Gamepiece();
Gamepiece b3 = new Gamepiece();
Gamepiece b4 = new Gamepiece();
Gamepiece b5 = new Gamepiece();
Gamepiece b6 = new Gamepiece();
Gamepiece b7 = new Gamepiece();
Gamepiece b8 = new Gamepiece();
Gamepiece b9 = new Gamepiece();
Gamepiece r01 = new Gamepiece();
Gamepiece r02 = new Gamepiece();
Gamepiece r03 = new Gamepiece();
Gamepiece r11 = new Gamepiece();
Gamepiece r12 = new Gamepiece();
Gamepiece r13 = new Gamepiece();
Gamepiece r21 = new Gamepiece();
Gamepiece r22 = new Gamepiece();
Gamepiece r23 = new Gamepiece();
Gamepiece r31 = new Gamepiece();
Gamepiece r32 = new Gamepiece();
Gamepiece r33 = new Gamepiece();
Gamepiece r34 = new Gamepiece();
Gamepiece r35 = new Gamepiece();
Gamepiece r36 = new Gamepiece();
Gamepiece r41 = new Gamepiece();
Gamepiece r42 = new Gamepiece();
Gamepiece r43 = new Gamepiece();
Gamepiece r51 = new Gamepiece();
Gamepiece r52 = new Gamepiece();
Gamepiece r53 = new Gamepiece();
Gamepiece r61 = new Gamepiece();
Gamepiece r62 = new Gamepiece();
Gamepiece r63 = new Gamepiece();
Gamepiece r71 = new Gamepiece();
Gamepiece r72 = new Gamepiece();
Gamepiece r73 = new Gamepiece();


for i = 0 to 6
	not_occupied[i] = taken[i];
	not_occupied[i+9] = taken[i+6];

not_occupied[0] = w1;
.
.
.
