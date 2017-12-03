import org.junit.jupiter.api.Assertions.*

/**
 * Created by vineshraju on 20/5/17.
 */
internal class TestKtUtil {
    @org.junit.jupiter.api.Test
    fun TEST_arrange() {
        assertEquals("az", "z za".arranged)
        assertEquals("az", "zzaa".arranged)
    }

    @org.junit.jupiter.api.Test
    fun TEST_getTransposedGroupsFor() {
        with(Util) {
            assertEquals("[a]", getTransposedGroupsFor(groups = arrayOf("a")).contentToString())
            assertEquals("[aaa, bbb, ccc]", getTransposedGroupsFor(groups = arrayOf("abc", "abc", "abc")).contentToString())
            assertEquals("[axae, bybf, c cg, d dh]", getTransposedGroupsFor(groups = arrayOf("abcd", "xy", "abcd", "efgh")).contentToString())
            assertEquals("[xaae, ybbf,  ccg,  ddh]", getTransposedGroupsFor(groups = arrayOf("xy", "abcd", "abcd", "efgh")).contentToString())
        }
    }

    @org.junit.jupiter.api.Test
    fun TEST_splitAlphabetsInto() {
        for (test in 1..52) {
            val result = Util.splitAlphabetsInto(groupsOf = test).contentToString()
            when (test) {
                1 -> assertEquals("[a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z]", result)
                2 -> assertEquals("[ab, cd, ef, gh, ij, kl, mn, op, qr, st, uv, wx, yz]", result)
                3 -> assertEquals("[abc, def, ghi, jkl, mno, pqr, stu, vwx, yz]", result)
                4 -> assertEquals("[abcd, efgh, ijkl, mnop, qrst, uvwx, yz]", result)
                5 -> assertEquals("[abcde, fghij, klmno, pqrst, uvwxy, z]", result)
                6 -> assertEquals("[abcdef, ghijkl, mnopqr, stuvwx, yz]", result)
                7 -> assertEquals("[abcdefg, hijklmn, opqrstu, vwxyz]", result)
                8 -> assertEquals("[abcdefgh, ijklmnop, qrstuvwx, yz]", result)
                9 -> assertEquals("[abcdefghi, jklmnopqr, stuvwxyz]", result)
                10 -> assertEquals("[abcdefghij, klmnopqrst, uvwxyz]", result)
                11 -> assertEquals("[abcdefghijk, lmnopqrstuv, wxyz]", result)
                12 -> assertEquals("[abcdefghijkl, mnopqrstuvwx, yz]", result)
                13 -> assertEquals("[abcdefghijklm, nopqrstuvwxyz]", result)
                14 -> assertEquals("[abcdefghijklmn, opqrstuvwxyz]", result)
                15 -> assertEquals("[abcdefghijklmno, pqrstuvwxyz]", result)
                16 -> assertEquals("[abcdefghijklmnop, qrstuvwxyz]", result)
                17 -> assertEquals("[abcdefghijklmnopq, rstuvwxyz]", result)
                18 -> assertEquals("[abcdefghijklmnopqr, stuvwxyz]", result)
                19 -> assertEquals("[abcdefghijklmnopqrs, tuvwxyz]", result)
                20 -> assertEquals("[abcdefghijklmnopqrst, uvwxyz]", result)
                21 -> assertEquals("[abcdefghijklmnopqrstu, vwxyz]", result)
                22 -> assertEquals("[abcdefghijklmnopqrstuv, wxyz]", result)
                23 -> assertEquals("[abcdefghijklmnopqrstuvw, xyz]", result)
                24 -> assertEquals("[abcdefghijklmnopqrstuvwx, yz]", result)
                25 -> assertEquals("[abcdefghijklmnopqrstuvwxy, z]", result)
                else -> assertEquals("[abcdefghijklmnopqrstuvwxyz]", result)
            }
        }
    }


}