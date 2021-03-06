// Testing finalize with inheritance.
class DoBaseFinalization
{
public static boolean flag = false;
}

class Characteristic
{
String s;
Characteristic(String c)
{
s = c;
System.out.println("Creating Characteristic " + s);
}
protected void finalize()
{
System.out.println("finalizing Characteristic " + s);
}
}

class LivingCreature
{
Characteristic p = new Characteristic("is alive");
LivingCreature() 
{
System.out.println("LivingCreature()");
}
protected void finalize() throws Throwable
{
System.out.println("LivingCreature finalize");
// Call base-class version LAST!
if(DoBaseFinalization.flag)
super.finalize();
}
}

class Animal extends LivingCreature
{
Characteristic p = new Characteristic("has heart");
Animal()
{
System.out.println("Animal()");
}
protected void finalize() throws Throwable
{
System.out.println("Animal finalize");
if(DoBaseFinalization.flag)
super.finalize();
}
}

class Amphibian extends Animal
{
Characteristic p = new Characteristic("can live in water");
Amphibian()
{
System.out.println("Amphibian()");
}
protected void finalize() throws Throwable
{
System.out.println("Amphibian finalize");
if(DoBaseFinalization.flag)
super.finalize();
}
}

public class FinalizeDemo extends Amphibian
{
FinalizeDemo()
{
System.out.println("FinalizeDemo()");
}
protected void finalize() throws Throwable 
{
System.out.println("FinalizeDemo finalize");
if(DoBaseFinalization.flag)
super.finalize();
}
public static void main(String[] args)
{
if(args.length != 0 &&
args[0].equals("finalize"))
DoBaseFinalization.flag = true;
else
System.out.println("Not finalizing bases");
new FinalizeDemo(); // Instantly becomes garbage
System.out.println("Bye!");
// Force finalizers to be called:
System.gc();
}
}