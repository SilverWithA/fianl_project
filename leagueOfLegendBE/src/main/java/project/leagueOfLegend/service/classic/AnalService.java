package project.leagueOfLegend.service.classic;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.leagueOfLegend.dto.cham.ChamDto;
import project.leagueOfLegend.dto.cham.ResponseChamDto;
import project.leagueOfLegend.entity.classic.*;
import project.leagueOfLegend.repository.classic.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
@RequiredArgsConstructor
public class AnalService {
    private final IronChamRepository ironChamRepository;
    private final BroChamRepository broChamRepository;
    private final SilChamRepository silChamRepository;
    private final GoldChamRepository goldChamRepository;
    private final PlaChamRepository plaChamRepository;
    private final EmChamRepository emChamRepository;
    private final DiaChamRepository diaChamRepository;
    private final MastChamRepository mastChamRepository;
    private final GrandChamRepository grandChamRepository;
    private final ChallChamRepository challChamRepository;


    public ResponseChamDto Anal(ChamDto dto) {
        String championname = dto.getChampion_name();
        String tier = dto.getTier();

        Map<String, String> championNameMapping = new HashMap<>();
        championNameMapping.put("카직스", "Khazix");
        championNameMapping.put("카이사", "Kaisa");
        championNameMapping.put("피오라", "Fiora");
        championNameMapping.put("우르곳", "Urgot");
        championNameMapping.put("아칼리", "Akali");
        championNameMapping.put("자이라", "Zyra");
        championNameMapping.put("조이", "Zoe");
        championNameMapping.put("질리언", "zilean");
        championNameMapping.put("직스", "Ziggs");
        championNameMapping.put("제리", "Zeri");
        championNameMapping.put("제드", "Zed");
        championNameMapping.put("자크", "Zac");
        championNameMapping.put("유미", "Yuumi");
        championNameMapping.put("요릭", "Yorick");
        championNameMapping.put("요네", "Yone");
        championNameMapping.put("야스오", "Yasuo");
        championNameMapping.put("신짜오", "XinZhao");
        championNameMapping.put("제라스", "Xerath");
        championNameMapping.put("자야", "Xayah");
        championNameMapping.put("워윅", "Warwick");
        championNameMapping.put("볼리베어", "Volibear");
        championNameMapping.put("블라디미르", "Vladimir");
        championNameMapping.put("빅토르", "Viktor");
        championNameMapping.put("비에고", "Viego");
        championNameMapping.put("바이", "Vi");
        championNameMapping.put("벡스", "Vex");
        championNameMapping.put("벨코즈", "Velkoz");
        championNameMapping.put("베이가", "Veigar");
        championNameMapping.put("베인", "Vayne");
        championNameMapping.put("바루스", "Varus");
        championNameMapping.put("우디르", "Udyr");
        championNameMapping.put("트위치", "Twitch");
        championNameMapping.put("트위스티드 페이트", "TwistedFate");
        championNameMapping.put("트린다미어", "Tryndamere");
        championNameMapping.put("트런들", "Trundle");
        championNameMapping.put("트리스타나", "Tristana");
        championNameMapping.put("쓰레쉬", "Thresh");
        championNameMapping.put("티모", "Teemo");
        championNameMapping.put("타릭", "Taric");
        championNameMapping.put("탈론", "Talon");
        championNameMapping.put("탈리야", "Taliyah");
        championNameMapping.put("탐켄치", "TahmKench");
        championNameMapping.put("신드라", "Syndra");
        championNameMapping.put("사일러스", "Sylas");
        championNameMapping.put("스웨인", "Swain");
        championNameMapping.put("소라카", "Soraka");
        championNameMapping.put("소나", "Sona");
        championNameMapping.put("스카너", "Skarner");
        championNameMapping.put("시비르", "Sivir");
        championNameMapping.put("사이온", "Sion");
        championNameMapping.put("신지드", "Singed");
        championNameMapping.put("쉬바나", "Shyvana");
        championNameMapping.put("쉔", "Shen");
        championNameMapping.put("샤코", "Shaco");
        championNameMapping.put("세트", "Sett");
        championNameMapping.put("세라핀", "Seraphine");
        championNameMapping.put("세나", "Senna");
        championNameMapping.put("세주아니", "Sejuani");
        championNameMapping.put("사미라", "Samira");
        championNameMapping.put("라이즈", "Ryze");
        championNameMapping.put("럼블", "Rumble");
        championNameMapping.put("리븐", "Riven");
        championNameMapping.put("렝가", "Rengar");
        championNameMapping.put("레넥톤", "Renekton");
        championNameMapping.put("레나타", "Renata");
        championNameMapping.put("렐", "Rell");
        championNameMapping.put("렉사이", "RekSai");
        championNameMapping.put("람머스", "Rammus");
        championNameMapping.put("라칸", "Rakan");
        championNameMapping.put("퀸", "Quinn");
        championNameMapping.put("키아나", "Qiyana");
        championNameMapping.put("파이크", "Pyke");
        championNameMapping.put("뽀삐", "Poppy");
        championNameMapping.put("판테온", "Pantheon");
        championNameMapping.put("오른", "Ornn");
        championNameMapping.put("오리아나", "Orianna");
        championNameMapping.put("올라프", "Olaf");
        championNameMapping.put("누누", "Nunu");
        championNameMapping.put("녹턴", "Nocturne");
        championNameMapping.put("닐라", "Nilah");
        championNameMapping.put("니달리", "Nidalee");
        championNameMapping.put("니코", "Neeko");
        championNameMapping.put("노틸러스", "Nautilus");
        championNameMapping.put("나서스", "Nasus");
        championNameMapping.put("나미", "Nami");
        championNameMapping.put("나피리", "Naafiri");
        championNameMapping.put("모로가나", "Morgana");
        championNameMapping.put("모데카이저", "Mordekaiser");
        championNameMapping.put("오공", "MonkeyKing");
        championNameMapping.put("미스포츈", "MissFortune");
        championNameMapping.put("밀리오", "Milio");
        championNameMapping.put("마스터이", "MasterYi");
        championNameMapping.put("마오카이", "Maokai");
        championNameMapping.put("말자하", "Malzahar");
        championNameMapping.put("말파이트", "Malphite");
        championNameMapping.put("럭스", "Lux");
        championNameMapping.put("룰루", "Lulu");
        championNameMapping.put("루시안", "Lucian");
        championNameMapping.put("리산드라", "Lissandra");
        championNameMapping.put("릴리아", "Lillia");
        championNameMapping.put("리신", "LeeSin");
        championNameMapping.put("레오나", "Leona");
        championNameMapping.put("르블랑", "Leblanc");
        championNameMapping.put("크산테", "KSante");
        championNameMapping.put("코그모", "KogMaw");
        championNameMapping.put("클레드", "Kled");
        championNameMapping.put("킨드레드", "Kindred");
        championNameMapping.put("케넨", "Kennen");
        championNameMapping.put("케인", "Kayn");
        championNameMapping.put("케일", "Kayle");
        championNameMapping.put("카타리나", "Katarina");
        championNameMapping.put("카사딘", "Kassadin");
        championNameMapping.put("카서스", "Karthus");
        championNameMapping.put("카르마", "Karma");
        championNameMapping.put("칼리스타", "Kalista");
        championNameMapping.put("징크스", "Jinx");
        championNameMapping.put("진", "Jhin");
        championNameMapping.put("제이스", "Jayce");
        championNameMapping.put("잭스", "Jax");
        championNameMapping.put("자르반", "JarvanIV");
        championNameMapping.put("잔나", "Janna");
        championNameMapping.put("아이번", "Ivern");
        championNameMapping.put("이렐리아", "Irelia");
        championNameMapping.put("일라오이", "Illaoi");
        championNameMapping.put("하이머딩거", "Heimerdinger");
        championNameMapping.put("헤카림", "Hecarim");
        championNameMapping.put("그웬", "Gwen");
        championNameMapping.put("나르", "Gnar");
        championNameMapping.put("가렌", "Garen");
        championNameMapping.put("갱플랭크", "Gangplank");
        championNameMapping.put("갈리오", "Galio");
        championNameMapping.put("그라가스", "Gragas");
        championNameMapping.put("피즈", "Fizz");
        championNameMapping.put("피들스틱", "FiddleSticks");
        championNameMapping.put("이즈리얼", "Ezreal");
        championNameMapping.put("이블린", "Evelynn");
        championNameMapping.put("엘리스", "Elise");
        championNameMapping.put("에코", "Ekko");
        championNameMapping.put("문도", "DrMundo");
        championNameMapping.put("드레이븐", "Draven");
        championNameMapping.put("다이애나", "Diana");
        championNameMapping.put("다리우스", "Darius");
        championNameMapping.put("코르키", "Corki");
        championNameMapping.put("초가스", "Chogath");
        championNameMapping.put("카시오페아", "Cassiopeia");
        championNameMapping.put("카밀", "Camille");
        championNameMapping.put("케이틀린", "Caitlyn");
        championNameMapping.put("브라이어", "Briar");
        championNameMapping.put("브라움", "Braum");
        championNameMapping.put("브랜드", "Brand");
        championNameMapping.put("블리츠 크랭크", "Blitzcrank");
        championNameMapping.put("벨베스", "Belveth");
        championNameMapping.put("바드", "Bard");
        championNameMapping.put("아지르", "Azir");
        championNameMapping.put("아우렐리온솔", "AurelionSol");
        championNameMapping.put("애쉬", "Ashe");
        championNameMapping.put("아펠리오스", "Aphelios");
        championNameMapping.put("애니", "Annie");
        championNameMapping.put("애니비아", "Anivia");
        championNameMapping.put("아무무", "Amumu");
        championNameMapping.put("알리스타", "Alistar");
        championNameMapping.put("아크샨", "Akshan");
        championNameMapping.put("아리", "Ahri");
        championNameMapping.put("아트록스", "Aatrox");
        championNameMapping.put("그레이브즈", "Graves");

        String champion_name = championNameMapping.get(championname);


        List list = new ArrayList<>();
//todo Champion
        List<IronCham> Ironlist = new ArrayList<>();
        List<BroCham> Brolist = new ArrayList<>();
        List<SilCham> Sillist = new ArrayList<>();
        List<GoldCham> Goldlist = new ArrayList<>();
        List<PlaCham> Plalist = new ArrayList<>();
        List<EmCham> Emlist = new ArrayList<>();
        List<DiaCham> Dialist = new ArrayList<>();
        List<MastCham> Mastlist = new ArrayList<>();
        List<GrandCham> Grandlist = new ArrayList<>();
        List<ChallCham> Challlist = new ArrayList<>();


        try {
                switch (tier) {
                    case "아이언":
                        Ironlist = ironChamRepository.findByAnal(champion_name);
                        break;
                    case "브론즈":
                        Brolist = broChamRepository.findByAnal(champion_name);
                        break;
                    case "실버":
                        Sillist = silChamRepository.findByAnal(champion_name);
                        break;
                    case "골드":
                        Goldlist = goldChamRepository.findByAnal(champion_name);
                        break;
                    case "플레티넘":
                        Plalist = plaChamRepository.findByAnal(champion_name);
                        break;
                    case "에메랄드":
                        Emlist = emChamRepository.findByAnal(champion_name);
                        break;
                    case "다이아":
                        Dialist = diaChamRepository.findByAnal(champion_name);
                        break;
                    case "마스터":
                        Mastlist = mastChamRepository.findByAnal(champion_name);
                        break;
                    case "그랜드마스터":
                        Grandlist = grandChamRepository.findByAnal(champion_name);
                        break;
                    case "챌린저":
                        Challlist = challChamRepository.findByAnal(champion_name);
                        break;
                }
            if (Ironlist.size() > 0) {
                list = Ironlist;
            } else if (Brolist.size() > 0) {
                list = Brolist;
            } else if (Sillist.size() > 0) {
                list = Sillist;
            } else if (Goldlist.size() > 0) {
                list = Goldlist;
            } else if (Plalist.size() > 0) {
                list = Plalist;
            } else if (Emlist.size() > 0) {
                list = Emlist;
            } else if (Dialist.size() > 0) {
                list = Dialist;
            } else if (Mastlist.size() > 0) {
                list = Mastlist;
            } else if (Grandlist.size() > 0) {
                list = Grandlist;
            } else if (Challlist.size() > 0) {
                list = Challlist;
            }
            if (list.isEmpty()) {
                return ResponseChamDto.setFailed("올바른 티어를 입력하세요");
            }
        }catch (Exception Error) {
            return ResponseChamDto.setFailed(Error.getMessage());
        }
        return ResponseChamDto.setSuccess("성공", list);
    }

}
