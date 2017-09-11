import java.util.*

/**
 * Created by Simas on 2017 Sep 07.
 */
class TowerOfHanoi(val name: Char, discs: IntArray) {

  companion object {
    private var step = 0

    @JvmStatic
    fun main(args: Array<String>) {
      // Read and sort n discs
      println("Enter n:")
      val line = readLine()
      val n = line?.toIntOrNull()
      if (n == null || n !in 1..10) {
        println("Invalid number entered $line.")
        main(args)
        return
      } else {
        println("Entered n = $n.")

        val discs = IntArray(n) { it + 1 }

        // Init towers
        val first = TowerOfHanoi('A', discs)
        val second = TowerOfHanoi('B', IntArray(0))
        val third = TowerOfHanoi('C', IntArray(0))

        println("Initial state $first, $second, $third")
        hb(first, second, third, n)
      }
    }

    fun hb(x: TowerOfHanoi, y: TowerOfHanoi, z: TowerOfHanoi, n: Int) {
      if (n <= 0) return
      hb(x, z, y, n - 1)
      x.discs.remove(n)
      z.discs.add(n)
      println(String.format("%4d. Move disc %s from %s to %s.", ++step, n, x, z))
      hb(y, x, z, n - 1)
    }
  }

  val discs = discs.toMutableList()

  override fun toString(): String {
    return "$name=(${Arrays.toString(discs.toTypedArray()).removeSurrounding("[", "]")})"
  }

}