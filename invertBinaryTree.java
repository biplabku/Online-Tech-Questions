import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class invertBinaryTree {

    public googlePrep.TreeNode root;

    public void swap(googlePrep.TreeNode root) {
        if(root == null) {
            return ;
        }
        googlePrep.TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }

    public googlePrep.TreeNode invertBinaryTree(googlePrep.TreeNode root) {
        Queue<googlePrep.TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            List<googlePrep.TreeNode> temp = new ArrayList<>();
            for(int i = 0; i < size; i++) {
                googlePrep.TreeNode t = queue.poll();
                swap(t);
                if(t.left != null) {
                    queue.add(t.left);
                }
                if(t.right != null) {
                    queue.add(t.right);
                }
            }
        }
        return root;
    }

    class charPoint{
        char ch;
        int count;

        public charPoint(char ch, int count) {
            this.ch = ch;
            this.count = count;
        }
    }

    public boolean repeatedSubstringRepeatedPattern(String str) {
        if(str.length() <= 1) {
            return false;
        }
        List<charPoint> map = new ArrayList<>();
        int count = 1;
        int i = 0;
        for(i = 0; i < str.length() - 1; i ++) {
            char ch1 = str.charAt(i);
            char ch2 = str.charAt(i + 1);
            if(ch1 == ch2) {
                count++;
            }else {
                charPoint c = new charPoint(ch1, count);
                map.add(c);
                count = 1;
            }
        }
        if(i <= str.length()) {
            map.add(new charPoint(str.charAt(str.length() - 1), count));
        }
        if(map.size() == 1) {
            return true;
        }
        // check the unique numbers from side to side
        int left = 0;
        int riht = map.size()/2;
        if(str.length() % 2 != 0) {
            return false;
        }
        while(left < map.size()/2) {
            charPoint c1 = map.get(left);
            charPoint c2 = map.get(riht);
            if(c1.ch == c2.ch && c1.count == c2.count) {
                left++;
                riht++;
            }else{
                return false;
            }
        }
        return true;
    }

    public boolean repeatedSubstringRepeatedPattern1(String str) {
        if(str.length() <= 1) {
            return false;
        }
        int count = 0;
        for(int i = 0; i < str.length(); i++) {
            String substring = str.substring(count, i+1);
            // check if the substring can be repeated to form the string
            if(checkRepeated(str, substring)) {
                return true;
            }
        }
        return false;
    }

    public boolean checkRepeated(String str, String pattern) {
        if(str.length() == pattern.length() ) {
            return false;
        }
        StringBuilder sb = new StringBuilder();
        while(sb.length() < str.length()) {
            sb.append(pattern);
            sb.toString().equalsIgnoreCase(str);
        }
        return false;
    }


    public static void main(String[] args) {
        invertBinaryTree ms = new invertBinaryTree();
        googlePrep.TreeNode t = new googlePrep.TreeNode(1);
        t.left = new googlePrep.TreeNode(2);
        t.left.left = new googlePrep.TreeNode(4);
        //t.left.right = new googlePrep.TreeNode(5);
        t.right = new googlePrep.TreeNode(3);
        t.right.left = new googlePrep.TreeNode(6);
        t.right.right = new googlePrep.TreeNode(7);
        String str = "prdttmqtookjbrryiwbouvkhgbrommxyhyscpnphvjllkwawtbwftgzczcrmviwpaacbsfuqpiqiyjwbeesmsbqmorjstvrgvmdizflhkkeumcptccryrkxzzxvygkemhbyfmhpexfoidjqvwfccqitxrppkrxlxrrvkvogcmgzqaivhbbgjtgfgpgspmlhfcgelhovcnamaizcaysvrpsnverowehpiztmedkixsxwzzseaozyzjvpvxetprasbndetckeemhqhfyqcdecgdtraxznlcdlwyxutryycmcxsyyscnutifyjecsudmhbfgpvymiovjwcmgsgzcebovlztfpknmtqlkxychrwxqfaumevtdkgbuqebyrnudvcfjydxqihvauauymxgdfjlemmpozgdzvsatcvemrojmxhvfmfbtdjywwephrzbutnuommunmnhmnqgfxxjwvregecxmqxmrukeynsgfsvkojfchcjuqmyypbndycjknlmxdjafhstcyszbujfxcduojzmynweqshnskjvbcdjhhhwckkrtebyzoqapwbebancwhmqwobvyxcfglwuwvyjfwwumcvovcghypywyiqbwjdgmedyhfppmmyafvwyavtdtuyzbmfxfeljberxdtlpavaxgectauqycnfgkhdcvhteiggngynbnqvpqtoxpktehmddebvbpeigccpnrraomgllylvkalezuprztzdlotldnjtgjywtawkykdjucbfmuwyvrqftrmbyjhfkndsehrlybncisumoczkxaadaleqwvjpqauhqgibmbxcivjdroaghxvwybphqkelwdoidxnygjtguhfqlthemedjmnhoclssfkrkzwalgapnbemkujrshojxqddkbqwfqkismfrxofgqibpqnngroephngywjakiozcceypzzaqcwqogbucjwaybvbmhgljjndcwcrxttkqdfcvacvrnjgwtexmeytarnltfiqqjrtxyfipyrshacohcdkovnktrdhopzdfyripyabgasnzxgpsxcrdhuiwaedcmuoigadrsmeowolpzsvywxihgebyqvuebmxcuoofumbxlntxzlhdexixaafuqrtrwompetjgaqwdlchxsxdtutibhnivvnudtkotiulxngwpgfytzhebjlrroabxcepbqvnnlygsyjhhohttgwvjuthdnrxkxzurxwjpneiglhcneqxgjlckxlmwwutpaionzyhsbmkpitkakbylnhdurxvunqrcwurvgznprfrhwrtpysqfbawwhuqdvjaosgivobaqfzfqfutniwuftxvjjlanuppywvlqnhrtxoezmokdezusxvidvtfkxbwhrkurathgbavskrixzhbjtbitijivamodyzqbnaasoudafojrmqzcmzdgxvhbqcebgdqekwisxpkysblxxgnreabrcowuinszcopghezmuekagcohqcrizdccwaenjfuztrkcxrkcnmxzgrvvjhgsaztaitjxhdaflspbnkhyyqvqwhullodqcbvphffimcsssasvwtqgijbhotypcguoeudqumblxtzxmnggrbhfrsemcatjmwoetgjvydqeykvubvodyexkeqwuvjdpawqvrkcgaqzoykoutlpoiytvseduaxwqhekunupqlvagdfdttbnbjswwbkmrfyceddqngweyfcuzrlgwrbzpypilwsnvkxkcfviybnrfwerbvvqgmqulhukecazlkdewkwtevkjcijbznrejkoilwidafqemxlrhyjmaltrzeojhatrajqbqgycnpudkbvajwwjfwvnhemecppdkeierofqxuisemskpjwihgnqbhrjhfbvatszcudryonznpsuzwsgwpwojhgmtqekelbjecuvachcbnrdzjopyugzyplnvensvobdyqqifyevtwblvwcueiaghnhsaoeqpdovftqhgxgpebzqbhwlcpgunzqeousobxwfzcjnbmrdjuwgfxojacxtczdxzrbnkjmbqbwdufmwqbtmcpvkohwwgozpethrrzzmrucrntxtwhooblrqbwwapsvwogajovblyeaesfrjanjjjhywbmsrnfnhdvqrkfebpwanpmpfzxorvadwaqtsotwtdsuiiizeqmdekntmxupctqzcnvozaitstehyvnakcharcfymsuqzrjmfbksvkezbvvqzdohnfjrbroihypehjiftqmdccprcargjhuoxqjpeckmnqdlaiukzzpdpcvvidkuzeyswefkfzbuyxzdwdstvqwmrnvwmkoyeoozqkpjbaymuwjadzjhhxrsjvxayvjqpynfufltfbgegsqharujbdsyyfqoiigrdomwwcfsqadrlntssbblposlmjbclcbhmeksstorsubikjvvllnhmpvsptzpkioyhrzonxtmfjnkwhshxmdmaigdukdvsqwugsijcwkbbnysiirdpamjxcqxmdecbqjzqygxlmkfuaymisqerabxafdovzbltsgmqybwckcjjzorzztsuvuxpnypwahqnwmbdspacyjtudxrzyiajshcxmozfvgxuopbqbkktskrjszzjylglxtnllwhjxdsavopcnvkkbjihlltkjydfmkhhhcjcvhroqxornqndjlhttvmmrnngubjenxrczwnpzedciiqulctdirosacqspvvbqzlyifoqsnrobbxuxlfreyhtipyqkfxjyfifmgepgxghnqluqgaosyifzabwjeugnxtnbfsmnfelxjdobxenqbmshbyivhitcjuybdzwqhkxyukegquzuenherugnmpbncpsxksffkldueazsiqzodffflmsqcxicwxavoloslttiidhnpnubxwuhbijcumtzfinkdrqursfihdgewyxbrpdpedemsjixjfrwxbpvswudjtecrftgzauljmjtbxsmxyyljjikobccpbzmxmtprxndbwyyhvteorfaemetqaheiffjjmmhmpwswxbzwlilcantsnqzsfxjvxezgoqujcyphlvkasdpjvditefhgllcpebakmfvphhawoxfsjlgympejxvqzvwvgzufujzjqbaytddpwwmrmfnsivjfneimyqcmihdhdeyzzuezcwlgxkvbgrgieticlbbntfbyknvbtuqkseuvmircdoissnbpykkvftovgkjxpjfphcrnaldcdcxcreezxjqnjztdmszjglqwmrllxehsirybojbnmvrrbclildtbxoswuqtqdassfljztyciqdbjipezfqgjzpbfjmyynxcfybmqckyohglxlpgpeibntumploqwpmabdbvddcbxynetamjqxtngdyhqwgzshyhyryhdoggclagdlnvvdidywvuosmajhdvlzkeixvtexskqsmvbnguaisovclsbxavomxatlrfbcnnddjpdvmqzrtleaqejvdfnersivuekyttucwfthashmzjtlmsedpecgxlpyxwnypvmbwfjdbdfbgofzpgljsprebqwloksghfqgdswbfhzxfmkddsdrysuwyoncnrmgybucxishzldhaybrqttrysvhdhouzkiepynplphlybwjpetdwgkgzneodvvtnxcatmkuborfmhsqbafsyikxiygevuuefxgcxygqjuykboanzklvacgjbbtejslubaugkwgmkrohoxaorospwucgprunuawlnruyfkfwnnbjvwdkhbixnwkasdrpintwarnphyyktemsyllyacjqvxskippmnykqutxswrggmtypwmkipkbaxlrdmenhoduaajlusrtumjvtuxrmtoqznzzkvaifmsnfobwdzohmvtaqvjrtirvqnjcslnmgbvjelnbdrptusjwbpwqfhwbhsvewywvcrwsfhcvkrvfpaayogwyxtsglwcyqrbdbpovvjsscouqwltbhxuvpuxemqwrpxgbqwjhxukxdvgcrzbabjvtgpjbdukfxozjzyujfunpdcrvvttvplnbvypweapjgxjqsxkmfggofrxwakgohgiwibeluoccycjcpolxzvedzftrqajrswxhjdqgunmdvcqmsyzinibdvdqsngojsjwnsqwgfxmutamuceczwlxwbvijdjhnmzdjtktzqjdmizirlyvjrapdqbueplmcegacybchhjvurzrrdybgscmlvptriuonzvklzysohkajfyzozryaqftxhldiwwplzuaasbuqmgnysfqdthtfrrkjdidgazpeiozyaduulzmovofzptcvnabaiwemxzmtqtkybldwesksefxqsllbwjnnawmnljxcdqjhamtjdsretstvwympscdqfvzdsneawsbkxufkqvbzonftrjpsefhilnizsjwsovoytsdzktbrbuuqmagjvmuhtloqpszqtjpytlkxkqdcrvhkadtjnzbkniddydbwswtgnaplplnuegmczqjrojttlwtplzmrqqlaotvkgpxujkjlpemflvagkkuyivuugfhvizaitmbhalreplfmvqdprdttmqtookjbrryiwbouvkhgbrommxyhyscpnphvjllkwawtbwftgzczcrmviwpaacbsfuqpiqiyjwbeesmsbqmorjstvrgvmdizflhkkeumcptccryrkxzzxvygkemhbyfmhpexfoidjqvwfccqitxrppkrxlxrrvkvogcmgzqaivhbbgjtgfgpgspmlhfcgelhovcnamaizcaysvrpsnverowehpiztmedkixsxwzzseaozyzjvpvxetprasbndetckeemhqhfyqcdecgdtraxznlcdlwyxutryycmcxsyyscnutifyjecsudmhbfgpvymiovjwcmgsgzcebovlztfpknmtqlkxychrwxqfaumevtdkgbuqebyrnudvcfjydxqihvauauymxgdfjlemmpozgdzvsatcvemrojmxhvfmfbtdjywwephrzbutnuommunmnhmnqgfxxjwvregecxmqxmrukeynsgfsvkojfchcjuqmyypbndycjknlmxdjafhstcyszbujfxcduojzmynweqshnskjvbcdjhhhwckkrtebyzoqapwbebancwhmqwobvyxcfglwuwvyjfwwumcvovcghypywyiqbwjdgmedyhfppmmyafvwyavtdtuyzbmfxfeljberxdtlpavaxgectauqycnfgkhdcvhteiggngynbnqvpqtoxpktehmddebvbpeigccpnrraomgllylvkalezuprztzdlotldnjtgjywtawkykdjucbfmuwyvrqftrmbyjhfkndsehrlybncisumoczkxaadaleqwvjpqauhqgibmbxcivjdroaghxvwybphqkelwdoidxnygjtguhfqlthemedjmnhoclssfkrkzwalgapnbemkujrshojxqddkbqwfqkismfrxofgqibpqnngroephngywjakiozcceypzzaqcwqogbucjwaybvbmhgljjndcwcrxttkqdfcvacvrnjgwtexmeytarnltfiqqjrtxyfipyrshacohcdkovnktrdhopzdfyripyabgasnzxgpsxcrdhuiwaedcmuoigadrsmeowolpzsvywxihgebyqvuebmxcuoofumbxlntxzlhdexixaafuqrtrwompetjgaqwdlchxsxdtutibhnivvnudtkotiulxngwpgfytzhebjlrroabxcepbqvnnlygsyjhhohttgwvjuthdnrxkxzurxwjpneiglhcneqxgjlckxlmwwutpaionzyhsbmkpitkakbylnhdurxvunqrcwurvgznprfrhwrtpysqfbawwhuqdvjaosgivobaqfzfqfutniwuftxvjjlanuppywvlqnhrtxoezmokdezusxvidvtfkxbwhrkurathgbavskrixzhbjtbitijivamodyzqbnaasoudafojrmqzcmzdgxvhbqcebgdqekwisxpkysblxxgnreabrcowuinszcopghezmuekagcohqcrizdccwaenjfuztrkcxrkcnmxzgrvvjhgsaztaitjxhdaflspbnkhyyqvqwhullodqcbvphffimcsssasvwtqgijbhotypcguoeudqumblxtzxmnggrbhfrsemcatjmwoetgjvydqeykvubvodyexkeqwuvjdpawqvrkcgaqzoykoutlpoiytvseduaxwqhekunupqlvagdfdttbnbjswwbkmrfyceddqngweyfcuzrlgwrbzpypilwsnvkxkcfviybnrfwerbvvqgmqulhukecazlkdewkwtevkjcijbznrejkoilwidafqemxlrhyjmaltrzeojhatrajqbqgycnpudkbvajwwjfwvnhemecppdkeierofqxuisemskpjwihgnqbhrjhfbvatszcudryonznpsuzwsgwpwojhgmtqekelbjecuvachcbnrdzjopyugzyplnvensvobdyqqifyevtwblvwcueiaghnhsaoeqpdovftqhgxgpebzqbhwlcpgunzqeousobxwfzcjnbmrdjuwgfxojacxtczdxzrbnkjmbqbwdufmwqbtmcpvkohwwgozpethrrzzmrucrntxtwhooblrqbwwapsvwogajovblyeaesfrjanjjjhywbmsrnfnhdvqrkfebpwanpmpfzxorvadwaqtsotwtdsuiiizeqmdekntmxupctqzcnvozaitstehyvnakcharcfymsuqzrjmfbksvkezbvvqzdohnfjrbroihypehjiftqmdccprcargjhuoxqjpeckmnqdlaiukzzpdpcvvidkuzeyswefkfzbuyxzdwdstvqwmrnvwmkoyeoozqkpjbaymuwjadzjhhxrsjvxayvjqpynfufltfbgegsqharujbdsyyfqoiigrdomwwcfsqadrlntssbblposlmjbclcbhmeksstorsubikjvvllnhmpvsptzpkioyhrzonxtmfjnkwhshxmdmaigdukdvsqwugsijcwkbbnysiirdpamjxcqxmdecbqjzqygxlmkfuaymisqerabxafdovzbltsgmqybwckcjjzorzztsuvuxpnypwahqnwmbdspacyjtudxrzyiajshcxmozfvgxuopbqbkktskrjszzjylglxtnllwhjxdsavopcnvkkbjihlltkjydfmkhhhcjcvhroqxornqndjlhttvmmrnngubjenxrczwnpzedciiqulctdirosacqspvvbqzlyifoqsnrobbxuxlfreyhtipyqkfxjyfifmgepgxghnqluqgaosyifzabwjeugnxtnbfsmnfelxjdobxenqbmshbyivhitcjuybdzwqhkxyukegquzuenherugnmpbncpsxksffkldueazsiqzodffflmsqcxicwxavoloslttiidhnpnubxwuhbijcumtzfinkdrqursfihdgewyxbrpdpedemsjixjfrwxbpvswudjtecrftgzauljmjtbxsmxyyljjikobccpbzmxmtprxndbwyyhvteorfaemetqaheiffjjmmhmpwswxbzwlilcantsnqzsfxjvxezgoqujcyphlvkasdpjvditefhgllcpebakmfvphhawoxfsjlgympejxvqzvwvgzufujzjqbaytddpwwmrmfnsivjfneimyqcmihdhdeyzzuezcwlgxkvbgrgieticlbbntfbyknvbtuqkseuvmircdoissnbpykkvftovgkjxpjfphcrnaldcdcxcreezxjqnjztdmszjglqwmrllxehsirybojbnmvrrbclildtbxoswuqtqdassfljztyciqdbjipezfqgjzpbfjmyynxcfybmqckyohglxlpgpeibntumploqwpmabdbvddcbxynetamjqxtngdyhqwgzshyhyryhdoggclagdlnvvdidywvuosmajhdvlzkeixvtexskqsmvbnguaisovclsbxavomxatlrfbcnnddjpdvmqzrtleaqejvdfnersivuekyttucwfthashmzjtlmsedpecgxlpyxwnypvmbwfjdbdfbgofzpgljsprebqwloksghfqgdswbfhzxfmkddsdrysuwyoncnrmgybucxishzldhaybrqttrysvhdhouzkiepynplphlybwjpetdwgkgzneodvvtnxcatmkuborfmhsqbafsyikxiygevuuefxgcxygqjuykboanzklvacgjbbtejslubaugkwgmkrohoxaorospwucgprunuawlnruyfkfwnnbjvwdkhbixnwkasdrpintwarnphyyktemsyllyacjqvxskippmnykqutxswrggmtypwmkipkbaxlrdmenhoduaajlusrtumjvtuxrmtoqznzzkvaifmsnfobwdzohmvtaqvjrtirvqnjcslnmgbvjelnbdrptusjwbpwqfhwbhsvewywvcrwsfhcvkrvfpaayogwyxtsglwcyqrbdbpovvjsscouqwltbhxuvpuxemqwrpxgbqwjhxukxdvgcrzbabjvtgpjbdukfxozjzyujfunpdcrvvttvplnbvypweapjgxjqsxkmfggofrxwakgohgiwibeluoccycjcpolxzvedzftrqajrswxhjdqgunmdvcqmsyzinibdvdqsngojsjwnsqwgfxmutamuceczwlxwbvijdjhnmzdjtktzqjdmizirlyvjrapdqbueplmcegacybchhjvurzrrdybgscmlvptriuonzvklzysohkajfyzozryaqftxhldiwwplzuaasbuqmgnysfqdthtfrrkjdidgazpeiozyaduulzmovofzptcvnabaiwemxzmtqtkybldwesksefxqsllbwjnnawmnljxcdqjhamtjdsretstvwympscdqfvzdsneawsbkxufkqvbzonftrjpsefhilnizsjwsovoytsdzktbrbuuqmagjvmuhtloqpszqtjpytlkxkqdcrvhkadtjnzbkniddydbwswtgnaplplnuegmczqjrojttlwtplzmrqqlaotvkgpxujkjlpemflvagkkuyivuugfhvizaitmbhalreplfmvqd";
        System.out.println(ms.repeatedSubstringRepeatedPattern1(str));
    }
}
