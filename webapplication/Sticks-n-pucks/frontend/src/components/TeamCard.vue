<template>
    <div class="m-8 max-w-sm rounded overflow-hidden shadow-lg" style="max-width: 20rem">
        <img class="w-full" src="/pics/Sticks'n'pucks.png" alt="logo">
        <div class="h-48 lg:h-auto lg:w-48 flex-none bg-cover rounded-t lg:rounded-t-none lg:rounded-l text-center overflow-hidden"
             style="background-image: url('/pics/Sticks'n'pucks.png')">
        </div>
        <div class="border-r border-b border-l border-gray-400 lg:border-l-0 lg:border-t lg:border-gray-400 bg-white rounded-b lg:rounded-b-none lg:rounded-r p-4 flex flex-col justify-between leading-normal">
            <div class="mb-8">
                <div class="text-gray-900 font-bold text-xl mb-2">{{ teamname }}</div>
                <p class="text-gray-700 text-base"> {{ description }} </p>
            </div>
            <div class="flex items-center">
                <img class="w-10 h-10 rounded-full mr-4" src="/pics/Sticks'n'pucks.png" alt="Manager picture">
                <div class="text-sm">
                    <p class="text-gray-900 leading-none">Manager name</p>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
    export default {
        name: "TeamCard",
        props: {
            teamname: {
                type: String,
                required: true,
            },
            description: {
                type: String,
                required: true,
            },
        }
    };
</script>

<style>
    @import "https://unpkg.com/tailwindcss@^2/dist/tailwind.min.css";
</style>