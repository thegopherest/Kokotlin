package Home2

abstract class Animal(var home : Living) : ForestPart
{
    var place : TreePart = home
    var hp : Int = 10
    val male : Boolean = Math.random() > 0.5

    abstract fun Gen(newAnimalProb: Double, secondAnimal: Animal)
    abstract fun Eat()

    fun Die()
    {
        home.animals.remove(this)
    }

    override fun NewDay() {
        hp -= 1
        if(hp <=0)
        {
            Die()
        }
    }
}

class Squirrel(var newHome: TrunkLiving): Animal(newHome)
{
    override fun Gen(newAnimalProb: Double, secondAnimal: Animal) {
        if (secondAnimal is Squirrel && male != secondAnimal.male && Math.random() > newAnimalProb)
        {
            home.livingAnimals.add(Squirrel(newHome))
        }
    }

    override fun Eat() {
        if (place is Crown && (place.myTree is Spruce || place.myTree is Pine || place.myTree is Walnut) && place.IsFood && place.Eat())
        {
            hp += 3
        }
    }
}

class FlyingSquirrel(var newHome: TrunkLiving): Animal(newHome)
{
    override fun Gen(newAnimalProb: Double, secondAnimal: Animal) {
        if (secondAnimal is FlyingSquirrel && male != secondAnimal.male && Math.random() > newAnimalProb)
        {
            home.livingAnimals.add(FlyingSquirrel(newHome))
        }
    }

    override fun Eat() {
        if (place is Crown && place.myTree is Maple && place.IsFood && place.Eat())
        {
            hp += 3
        }
    }

}

class Woodpecker(var newHome: TrunkLiving): Animal(newHome)
{
    override fun Gen(newAnimalProb: Double, secondAnimal: Animal) {
        if (secondAnimal is Woodpecker && male != secondAnimal.male && Math.random() > newAnimalProb)
        {
            home.livingAnimals.add(Woodpecker(newHome))
        }
    }
    override fun Eat() {
        if (place is Trunk && place.IsFood && place.Eat())
        {
            hp += 3
        }
    }
}

class Chimunks(var newHome: RootsLiving): Animal(newHome)
{
    override fun Gen(newAnimalProb: Double, secondAnimal: Animal) {
        if (secondAnimal is Chimunks && male != secondAnimal.male && Math.random() > newAnimalProb)
        {
            home.livingAnimals.add(Chimunks(newHome))
        }
    }
    override fun Eat() {
        if (place is Roots && (place.myTree is Spruce || place.myTree is Pine || place.myTree is Walnut) && place.IsFood && place.Eat())
        {
            hp += 3
        }
    }
}

//� ������� ������ �����, ��� ����� ������ ���. ������� ������� ���� ���� �����.
class Badgers(var newHome: RootsLiving): Animal(newHome)
{
    override fun Gen(newAnimalProb: Double, secondAnimal: Animal) {
        if (secondAnimal is Badgers && male != secondAnimal.male && Math.random() > newAnimalProb)
        {
            home.livingAnimals.add(Badgers(newHome))
        }
    }
    override fun Eat() {
        if (place is Roots && (place.myTree is Spruce || place.myTree is Pine || place.myTree is Walnut) && place.IsFood && place.Eat())
        {
            hp += 3
        }
    }
}


