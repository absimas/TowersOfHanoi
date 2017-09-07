import java.util.*

/**
 * Created by Simas on 2017 Sep 07.
 */
class TowerOfHanoi(val name: Char, vararg discs: Int) {

  companion object {
    private var step = 0

    @JvmStatic
    fun main(args: Array<String>) {
      // Init towers
      val first = TowerOfHanoi('A', 3, 2, 1)
      val second = TowerOfHanoi('B')
      val third = TowerOfHanoi('C')

      // Read and sort n discs
      println("Enter n:")
      val line = readLine()
      val n = line?.toIntOrNull()
      if (n == null || n !in 1..10) {
        throw IllegalStateException("Invalid line entered: '$line'!")
      } else {
        println("Entered n = $n.")
        println("Initial state $first, $second, $third")
        hb(first, second, third, n)
      }
    }

    fun hb(x: TowerOfHanoi, y: TowerOfHanoi, z: TowerOfHanoi, n: Int) {
      if (n <= 0) return
      hb(x, z, y, n - 1)
      x.discs.remove(n)
      z.discs.add(n)
      println("${++step}. Move disc $n from $x to $z")
      hb(y, x, z, n - 1)
    }
  }

  val discs = discs.toMutableList()

  override fun toString(): String {
    return "$name=(${Arrays.toString(discs.toTypedArray()).removeSurrounding("[", "]")})"
  }

}