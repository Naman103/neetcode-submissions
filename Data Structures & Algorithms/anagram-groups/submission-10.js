class Solution {
    /**
     * @param {string[]} strs
     * @return {string[][]}
     */
    groupAnagrams(strs) {
        let result = new Map();
        for (let s of strs) {
            const sortedS = s.split('').sort().join();
            if (!result[sortedS])
                result[sortedS] = [];
            
            result[sortedS].push(s)
        }

        return Object.values(result);
    }
}
