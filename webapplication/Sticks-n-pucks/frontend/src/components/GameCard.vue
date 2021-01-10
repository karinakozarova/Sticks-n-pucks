<template>
    <div class="main-wrapper" style="background-image: url('/pics/puck-drop.jpg')">
        <div class="schedule">
            <div class="cellcontainer left-team">
                <div class="team-info">
                    <div class="team-title">{{ hostname }}</div>
                    <div class="team-color" style="background-color: rgb(21, 149, 211);"></div>
                </div>
                <div class="team-score"> {{ hostscore }} </div>
            </div>
            <div class="cellcontainer cellcontainer--scoring">
                <div class="versus">VS</div>
                <div class="game-date">{{ gamedate }}</div>
            </div>
            <div class="cellcontainer right-team">
                <div class="team-score"><span>{{ guestscore }}</span></div>
                <div class="team-info">
                    <div class="team-title">{{ guestname }} </div>
                    <div class="team-color" style="background-color: rgb(206, 33, 31);"></div>
                </div>
            </div>
        </div>
        <div>
        </div>
    </div>
</template>

<script>
    export default {
        name: "GameCard",
        props: {
            hostname: {
                type: String,
                required: true,
            },
            hostscore: {
                type: String,
                required: false,
            },
            guestname: {
                type: String,
                required: true,
            },
            guestscore: {
                type: String,
                required: false,
            },
            gamedate: {
                type: String,
                required: false,
            },
        }
    };
</script>

<style>
    @import "https://unpkg.com/tailwindcss@^2/dist/tailwind.min.css";

</style>
<link rel="stylesheet" href="/css/game.css">
